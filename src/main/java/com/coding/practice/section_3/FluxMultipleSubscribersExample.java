package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FluxMultipleSubscribersExample {
    public static void main(String[] args) {

        var flux = Flux.just(1, 2, 3, 4, 5);

        flux.subscribe(Util.subscriber("sub1"));

        flux
                .filter(data -> data % 2 == 0)
                .subscribe(Util.subscriber("sub2"));

        flux
                .filter(elem -> elem % 2 == 1)
                .subscribe(Util.subscriber("sub3"));
    }
}
