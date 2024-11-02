package com.coding.practice.section_4;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

public class FluxGenerateOptions {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FluxGenerateOptions.class);

    public static void main(String[] args) {
        Flux.generate(
                () -> 0,
                (counter, sink) -> {
                    var country = Util.faker().country().name();
                    sink.next(country);
                    counter += 1;
                    if (counter == 10 || country.equalsIgnoreCase("canada")) {
                        sink.complete();
                    }
                    return counter;
                },
                System.out::println
        ).subscribe(Util.subscriber());
    }
}
