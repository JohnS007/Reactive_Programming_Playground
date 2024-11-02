package com.coding.practice.section_2;

import com.coding.practice.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonoDeferExample {
    private static final Logger log = LoggerFactory.getLogger(MonoDeferExample.class);

    public static void main(String[] args) {

//        Mono.fromSupplier(
//                () -> calcSumFromList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6))
//        )
//                .subscribe(Util.subscriber());

       // createPublisher(); I don;t even want to create a publisher and want it to be defered till I actually subscribe and work on something

       Mono.defer(MonoDeferExample::createPublisher) //This is what I would want to see
               .subscribe(Util.subscriber());

    }

    private static Mono<Integer> createPublisher(){
        log.info("Creating a publisher");
        return Mono.fromSupplier(
                () -> calcSumFromList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6))
        );
    }

    private static int calcSumFromList(List<Integer>...lists){
        log.info("Working on the task after subscribing");
        return Arrays
                .stream(lists)
                .reduce(new ArrayList<>(), (a, b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList()))
                .stream()
                .peek(System.out::print)
                .reduce(0, Integer::sum);
    }
}
