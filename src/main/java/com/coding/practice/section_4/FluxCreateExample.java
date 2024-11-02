package com.coding.practice.section_4;

import com.coding.practice.common.Util;
import com.coding.practice.section_4.helper.CustomFluxDataSink;
import com.coding.practice.section_4.helper.NameFluxSink;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FluxCreateExample {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            fluxSink.next(1);
            fluxSink.next("JS");
            fluxSink.next(Arrays.asList(1, 2, 3));
        }).subscribe(Util.subscriber());

        //Now I want to do the same thing but need a custom class to do the same thing, May be we can reuse that class later
        //For some different purpose but, I do not want to work everything in one lambda expression

//        var customDataSink = new CustomFluxDataSink<>();
//        var flux = Flux.create(customDataSink);
//        flux.subscribe(Util.subscriber());


//        var nameFluxSink = new NameFluxSink();
//        var flux = Flux.create(nameFluxSink);
//        flux.subscribe(Util.subscriber());
//
//        IntStream.rangeClosed(1, 10).forEach((id) -> nameFluxSink.generateName());
    }
}
