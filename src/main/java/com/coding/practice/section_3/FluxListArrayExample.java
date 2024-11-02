package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxListArrayExample {
    public static void main(String[] args) {
        var list= List.of(1, 2, 3, 4, 5);
        Flux.fromIterable(list)
                .subscribe(Util.subscriber());

        var array = new Integer[]{1, 2, 4, 5, 6};
        Flux.fromArray(array)
                .subscribe(Util.subscriber());
    }
}
