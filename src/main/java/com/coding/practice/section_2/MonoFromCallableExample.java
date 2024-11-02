package com.coding.practice.section_2;

import com.coding.practice.common.Util;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonoFromCallableExample {
    public static void main(String[] args) {

        //Supplier does not handle checked exception by default, we need to handle them by our own

//        Mono.fromSupplier(
//                () -> calcSumFromList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6))
//        )
//                .subscribe(Util.subscriber());

        //Callable handles checked exception by default so not complaints from compiler

        Mono.fromCallable(
                        () -> calcSumFromList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6))
                )
                .subscribe(Util.subscriber());

    }

    private static int calcSumFromList(List<Integer>...lists) throws Exception{
        return Arrays
                .stream(lists)
                .reduce(new ArrayList<>(), (a, b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList()))
                .stream()
                .peek(System.out::print)
                .reduce(0, Integer::sum);
    }
}
