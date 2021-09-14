package com.tiagocomputer;

import com.tiagocomputer.consumer.ConsumerService;
import com.tiagocomputer.consumer.ServiceRunner;
import com.tiagocomputer.dispatcher.KafkaDispatcher;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.concurrent.ExecutionException;

public class EmailNewOrderService implements ConsumerService<BookingOrder> {

    public static void main(String[] args) {
        new ServiceRunner(EmailNewOrderService::new).start(1);
    }

    private final KafkaDispatcher<String> emailDispatcher = new KafkaDispatcher<>();

    public void parse(ConsumerRecord<String, Message<BookingOrder>> record) throws ExecutionException, InterruptedException {
        System.out.println("------------------------------------------");
        System.out.println("Processing new booking order, preparing email");
        var message = record.value();
        System.out.println(message);

        var order = message.getPayload();
        var emailCode = "Thank you for your order! We are processing your booking order!";
        var id = message.getId().continueWith(EmailNewOrderService.class.getSimpleName());
        emailDispatcher.send("BOOKING_SEND_EMAIL", order.getEmail(),
                id, emailCode);
    }

    @Override
    public String getTopic() {
        return "BOOKING_NEW_ORDER";
    }

    @Override
    public String getConsumerGroup() {
        return EmailNewOrderService.class.getSimpleName();
    }

}
