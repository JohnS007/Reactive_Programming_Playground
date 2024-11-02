package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class FluxJustExample {
    public static void main(String[] args) {
        Flux.just(1, 2, "Sam", 4.5, Arrays.asList(2, 3, 4, 5))
                .subscribe(Util.subscriber());
    }
}
