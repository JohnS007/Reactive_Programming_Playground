package com.coding.practice.section_3.helper;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.IntStream;

public class NameGenerator {
    public static List<String> getNamesList(){
        return IntStream.rangeClosed(1, 10)
                .mapToObj(id -> generateName())
                .toList();
    }

    public static Flux<String> getNamesFlux(){
        return Flux.range(1, 10)
                .map(id -> generateName());
    }

    private static String generateName(){
        Util.sleepSeconds(1);
        return Util.faker().name().firstName();
    }
}
