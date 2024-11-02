package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class FluxLogExample {
    public static void main(String[] args) {
//
//        Flux.range(1, 5)
//                .subscribe(Util.subscriber("My-Subscriber"));

//        Flux.range(1, 5)
//                .log()
//                .subscribe(Util.subscriber("My-Subscriber"));

        Flux.range(1, 5)
                .log("range-to-map")
                .map(data -> Util.faker().name().firstName())
                .log("map-to-my-subscriber")
                .subscribe(Util.subscriber("My-Subscriber"));
    }
}
