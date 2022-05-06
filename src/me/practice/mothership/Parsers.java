package me.practice.mothership;

import java.util.Map;
import java.util.function.Function;

public class Parsers {

    public static final Map<Class<?>, Function<String, Number>> parsers = Map.of(
            Float.class, Float::valueOf,
            Double.class, Double::valueOf,
            Integer.class, Integer::valueOf,
            Long.class, Long::valueOf
    );
}
