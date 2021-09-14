package com.tiagocomputer.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum PaymentMethodsEnums {
    CREDIT_CARD("credit_card"),
    AGENCY_ACCOUNT("agency_account"),
    TRAVEL_AGENT_ID("travel_agent_id"),
    CORPORATE_ID("corporate_id"),
    HOTEL_GUEST_ID("hotel_guest_id"),
    CHECK("check"),
    MISC_CHARGE_ORDER("misc_charge_order"),
    ADVANCE_DEPOSIT("advance_deposit"),
    COMPANY_ADDRESS("company_address");

    private static final Map<String, PaymentMethodsEnums> mapString = new HashMap<>();

    static {
        for (final PaymentMethodsEnums paymentMethodsEnums : EnumSet.allOf(PaymentMethodsEnums.class)) {
            mapString.put(paymentMethodsEnums.getValue().toLowerCase(), paymentMethodsEnums);
        }
    }

    private final String value;

    PaymentMethodsEnums(final String value) {
        this.value = value;
    }

    public static PaymentMethodsEnums entryOf(final String paymentMethodsEnums) {
        return StringUtils.isNotBlank(paymentMethodsEnums) ? mapString.get(paymentMethodsEnums.toLowerCase()) : null;
    }

    public static boolean exists(final String paymentMethodsEnums) {
        return StringUtils.isNotBlank(paymentMethodsEnums) && mapString.containsKey(paymentMethodsEnums.toLowerCase());
    }
}
