package com.coding.practice.section_4.helper;

import com.coding.practice.common.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameFluxSink implements Consumer<FluxSink<String>> {

    private FluxSink<String> stringFluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.stringFluxSink = stringFluxSink;
    }

    public void generateName(){
        this.stringFluxSink.next(Util.faker().name().firstName());
    }


}
