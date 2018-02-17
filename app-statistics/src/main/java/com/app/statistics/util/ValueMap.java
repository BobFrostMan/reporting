package com.app.statistics.util;

import java.util.Map;

public class ValueMap {
    private Map<String, Object> map;

    public ValueMap(Map<String, Object> map) {
        this.map = map;
    }

    public boolean isEmpty() {
        return map == null || map.isEmpty();
    }

    public boolean contains(final String key) {
        return !isEmpty() && map.containsKey(key);
    }

    public <T> T get(final String key, final Class<T> valueType) {
        if (contains(key)) {
            return (T) map.get(key);
        }
        return null;
    }

    public <T> T get(final String key, final Class<T> valueType, final T defaultValue) {
        final T value = get(key, valueType);
        return value == null ? defaultValue : value;
    }

    public <T extends Enum<T>> T getEnum(final String key, final Class<T> valueType) {
        final String enumValue = get(key, String.class);
        if (enumValue == null) {
            return null;
        }
        return EnumUtil.adaptToEnum(enumValue.trim().toUpperCase(), valueType);
    }

    public <T extends Enum<T>> T getEnum(final String key, final Class<T> valueType, final T defaultValue) {
        final T result = getEnum(key, valueType);
        return result == null ? defaultValue : result;
    }
}
