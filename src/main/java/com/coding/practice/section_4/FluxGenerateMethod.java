package com.coding.practice.section_4;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

/*
    Flux generate behavior
    - Invokes lambda expression repeatedly based on downstream demand
    - Can emit only one value at a time
    - will stop when complete method is called
    - will stop when error method is called
    - will stop when downstream cancels
 */



public class FluxGenerateMethod {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FluxGenerateMethod.class);

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().country().name());
        })
                .take(4)
                .subscribe(Util.subscriber());



        Flux.<String>generate(synchronousSink -> {
            synchronousSink.next(Util.faker().country().name());
        })
                .takeWhile(country -> !country.equalsIgnoreCase("canada"))
                .subscribe(Util.subscriber());


        Flux.<String>generate(synchronousSink -> {
                    synchronousSink.next(Util.faker().country().name());
                })
                .takeUntil(country -> country.equalsIgnoreCase("canada"))
                .subscribe(Util.subscriber());


    }
}
