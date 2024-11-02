package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxFromStreamExample {
    public static void main(String[] args) {
       var list = List.of(1, 2, 3, 4, 5);
       var stream = list.stream();

       var flux = Flux.fromStream(list::stream); //Create multiple streams for multiple subscribers

       flux.subscribe(Util.subscriber("sub1"));
       flux.subscribe(Util.subscriber("sub2"));




    }
}
