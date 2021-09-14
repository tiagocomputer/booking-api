package com.tiagocomputer;

import com.tiagocomputer.consumer.KafkaService;
import com.tiagocomputer.dispatcher.KafkaDispatcher;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FraudDetectorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var fraudService = new FraudDetectorService();
        try (var service = new KafkaService<>(FraudDetectorService.class.getSimpleName(),
                "BOOKING_NEW_ORDER",
                fraudService::parse,
                Map.of())) {
            service.run();
        }
    }

    private final KafkaDispatcher<BookingOrder> orderDispatcher = new KafkaDispatcher<>();

    private void parse(ConsumerRecord<String, Message<BookingOrder>> record) throws ExecutionException, InterruptedException {
        System.out.println("------------------------------------------");
        System.out.println("Processing new booking order, checking for fraud");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());

        var message = record.value();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }
        var order = message.getPayload();
        if(isFraud(order)) {
            // pretending that the fraud happens when the amount is >= 4500
            System.out.println("Booking Order is a fraud!!!!!" + order);
            orderDispatcher.send("BOOKING_ORDER_REJECTED", order.getEmail(),
                    message.getId().continueWith(FraudDetectorService.class.getSimpleName()),
                    order);
        } else {
            System.out.println("Approved: " + order);
            orderDispatcher.send("BOOKING_ORDER_APPROVED", order.getEmail(),
                    message.getId().continueWith(FraudDetectorService.class.getSimpleName()),
                    order);
        }

    }

    private boolean isFraud(BookingOrder bookingOrder) {
        return bookingOrder.getAmount().compareTo(new BigDecimal("4500")) >= 0;
    }

}
