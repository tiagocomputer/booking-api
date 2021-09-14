package com.tiagocomputer.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum CancellationPoliceEnums {
    FULL_STAY("full_stay"),
    Flat("flat"),
    Flat_Per_Night("flat_per_night"),
    Stay_Percent("stay_percent"),
    FirstNight("first_night"),
    LastNight("last_night"),
    First_And_Last_Night("first_and_last_night");

    private static final Map<String, CancellationPoliceEnums> mapString = new HashMap<>();

    static {
        for (final CancellationPoliceEnums cancellationPoliceEnums : EnumSet.allOf(CancellationPoliceEnums.class)) {
            mapString.put(cancellationPoliceEnums.getValue().toLowerCase(), cancellationPoliceEnums);
        }
    }

    private final String value;

    CancellationPoliceEnums(final String value) {
        this.value = value;
    }

    public static CancellationPoliceEnums entryOf(final String cancellationPoliceEnums) {
        return StringUtils.isNotBlank(cancellationPoliceEnums) ? mapString.get(cancellationPoliceEnums.toLowerCase()) : null;
    }

    public static boolean exists(final String cancellationPoliceEnums) {
        return StringUtils.isNotBlank(cancellationPoliceEnums) && mapString.containsKey(cancellationPoliceEnums.toLowerCase());
    }
}
