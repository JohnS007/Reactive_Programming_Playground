package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxDeferExample {
    public static final Logger log = LoggerFactory.getLogger(FluxDeferExample.class);

    public static void main(String[] args) {

        // This we do not want... :(
       // var flux = getFluxOfList();

        //This is what we want.. :)
        var flux = Flux.defer(FluxDeferExample::getFluxOfList);
        flux.subscribe(Util.subscriber());

    }

    private static List<Integer> createList(){
        log.info("Creating the list");
        return List.of(1, 2, 3, 4, 5);
    }

    private static Flux<Integer> getFluxOfList(){
        log.info("Creating the flux from received list");
        return Flux.fromIterable(createList());
    }
}
