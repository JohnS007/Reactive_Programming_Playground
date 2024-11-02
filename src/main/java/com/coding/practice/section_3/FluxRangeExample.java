package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class FluxRangeExample {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .map(data-> data + " " + Util.faker().name().fullName())
                .subscribe(Util.subscriber());

//        Flux.range(3, 5)
//                .map(i -> i / i-4)
//                .subscribe((response -> System.out.println(response)),
//                        (error) -> error.printStackTrace(),
//                        () -> System.out.println("OnComplete"),
//                        subscription -> subscription.request(Long.MAX_VALUE));
    }
}
