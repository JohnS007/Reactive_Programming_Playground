package com.coding.practice.section_4;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

public class FluxTakeOperator {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FluxTakeOperator.class);

    /*
        take() operator is similar to the java 8 limit()
     */

    public static void main(String[] args) {

        //limitAndTakeComparison();

        //takeOperatorVariations();


    }

    private static void takeOperatorVariations() {
        Flux.range(1, 10)
                .log("takeWhile")
                .takeWhile( elem -> elem < 5)
                .log("subscriber")
                .subscribe(Util.subscriber());

        Flux.range(1, 10)
                .log("takeUntil")
                .takeUntil(elem -> elem < 5)
                .log("subscriber")
                .subscribe(Util.subscriber());
    }

    private static void limitAndTakeComparison() {
        IntStream.rangeClosed(1, 10)
                .limit(3)
                .forEach(System.out::println);

        Flux.range(1, 10)
                .log("take")
                .take(3)
                .log("subscriber")
                .subscribe(Util.subscriber());
    }
}
