package com.tiagocomputer.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum PaymentTypeEnums {
    GARANTEE("guarantee"),
    DEPOSITI("deposit"),
    PREPAY("prepay"),
    HOLDTIME("holdTime");

    private static final Map<String, PaymentTypeEnums> mapString = new HashMap<>();

    static {
        for (final PaymentTypeEnums paymentTypeEnums : EnumSet.allOf(PaymentTypeEnums.class)) {
            mapString.put(paymentTypeEnums.getValue().toLowerCase(), paymentTypeEnums);
        }
    }

    private final String value;

    PaymentTypeEnums(final String value) {
        this.value = value;
    }

    public static PaymentTypeEnums entryOf(final String paymentTypeEnums) {
        return StringUtils.isNotBlank(paymentTypeEnums) ? mapString.get(paymentTypeEnums.toLowerCase()) : null;
    }

    public static boolean exists(final String paymentTypeEnums) {
        return StringUtils.isNotBlank(paymentTypeEnums) && mapString.containsKey(paymentTypeEnums.toLowerCase());
    }
}
