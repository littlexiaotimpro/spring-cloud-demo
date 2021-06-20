package com.spring.cloud.common.api.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class ParameterizedTypeUtil {
    private ParameterizedTypeUtil() {
    }

    public static Type forType(Type raw, Type... args) {
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return args;
            }

            @Override
            public Type getRawType() {
                return raw;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }
}
