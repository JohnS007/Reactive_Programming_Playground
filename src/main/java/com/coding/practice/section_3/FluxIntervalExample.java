package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

public class FluxIntervalExample {
    public static void main(String[] args) {
        Flux.interval(Duration.ofMillis(500))
                .map(id->Util.faker().name().firstName())
                .subscribe(Util.subscriber());
        Util.sleepSeconds(5);
    }
}
