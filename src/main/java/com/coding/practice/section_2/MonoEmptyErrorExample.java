package com.coding.practice.section_2;

import com.coding.practice.common.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyErrorExample {
    public static void main(String[] args) {

        getUserName(3)
                .subscribe(Util.subscriber());

    }

    private static Mono<String> getUserName(int userId){
        return switch (userId){
            case 1 -> Mono.just("Johnty");
            case 2 -> Mono.empty(); //No data to give, just like null
            default -> Mono.error(new RuntimeException("Invalid data"));
        };
    }
}
