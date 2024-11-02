package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class FluxMonoConversionExample {

    public static void main(String[] args) {
        //Converting flux to mono
        var flux = Flux.range(1, 10);

        //Using next() we can get next value and treat it as mono
        flux.next().subscribe(Util.subscriber());

        //Using from() of Mono we can do the same thing !
        Mono.from(flux).subscribe(Util.subscriber());
    }

    private static void monoToFlux() {
        var mono = getUserName(3);
        save(Flux.from(mono));
    }

    private static void save(Flux<String> flux){
        flux.subscribe(Util.subscriber());
    }

    private static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("Johnty");
            case 2 -> Mono.empty(); //No data to give, just like null
            default -> Mono.error(new RuntimeException("Invalid data"));
        };
    }
}
