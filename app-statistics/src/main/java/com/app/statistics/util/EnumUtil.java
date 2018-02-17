package com.app.statistics.util;

public class EnumUtil {

    public static <T extends Enum<T>> T adaptEnum(final Enum value, final Class<T> enumType) {
        if (value == null) {
            return null;
        }
        return adaptToEnum(value.name(), enumType);
    }

    public static <T extends Enum<T>> T adaptToEnum(final String value, final Class<T> valueType) {
        if (value == null) {
            return null;
        }
        return Enum.valueOf(valueType, value);
    }
}
