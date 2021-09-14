package com.tiagocomputer.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum BoardTypeEnums {
    ROOM_ONLY("room_only"),
    BREAKFAST("breakfast"),
    HALF_BOARD("half_board"),
    FULL_BOARD("full_board"),
    ALL_INCLUSIVE("all_inclusive"),
    BUFFET_BREAKFAST("buffet_breakfast"),
    CARIBBEAN_BREAKFAST("caribbean_breakfast"),
    CONTINENTAL_BREAKFAST("continental_breakfast"),
    ENGLISH_BREAKFAST("english_breakfast"),
    FULL_BREAKFAST("full_breakfast"),
    DINNER_BED_AND_BREAKFAST("dinner_bed_and_breakfast"),
    LUNCH("lunch"),
    DINNER("dinner"),
    FAMILY_PLAN("family_plan");

    private static final Map<String, BoardTypeEnums> mapString = new HashMap<>();

    static {
        for (final BoardTypeEnums boardTypeEnums : EnumSet.allOf(BoardTypeEnums.class)) {
            mapString.put(boardTypeEnums.getValue().toLowerCase(), boardTypeEnums);
        }
    }

    private final String value;

    BoardTypeEnums(final String value) {
        this.value = value;
    }

    public static BoardTypeEnums entryOf(final String boardType) {
        return StringUtils.isNotBlank(boardType) ? mapString.get(boardType.toLowerCase()) : null;
    }

    public static boolean exists(final String boardType) {
        return StringUtils.isNotBlank(boardType) && mapString.containsKey(boardType.toLowerCase());
    }
}