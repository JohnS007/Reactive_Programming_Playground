package com.coding.practice.section_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoOverloadedMethodsExample {

    private static final Logger log = LoggerFactory.getLogger(MonoOverloadedMethodsExample.class);

    public static void main(String[] args) {
        var mono = Mono.just(1);
                //.map(data -> data / 0);
        mono.subscribe(response -> log.info("Recevied Response: {}", response),
                       error -> log.info("Recevied error: {}", error),
                        () -> log.info("Completed and no more items to emit"),
                        subscription -> subscription.request(1) //The default call is subscription.request(Long.MAX_VALUE)
        );
    }
}
