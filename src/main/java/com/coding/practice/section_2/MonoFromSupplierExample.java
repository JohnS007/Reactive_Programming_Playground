package com.coding.practice.section_2;

import com.coding.practice.common.Util;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonoFromSupplierExample {
    public static void main(String[] args) {

        //Here we want to return after computation
        Mono.fromSupplier(
                () -> calcSumFromList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6))
        )
                .subscribe(Util.subscriber());

    }

    private static int calcSumFromList(List<Integer>...lists){
        return Arrays
                .stream(lists)
                .reduce(new ArrayList<>(), (a, b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList()))
                .stream()
                .peek(System.out::print)
                .reduce(0, Integer::sum);
    }
}
