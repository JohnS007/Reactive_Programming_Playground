package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class FluxEmptyErrorExample {
    public static void main(String[] args) {

        Flux.empty()
                .subscribe(Util.subscriber());

        Flux.error(new RuntimeException("Testing"))
                .subscribe(Util.subscriber());
    }
}
