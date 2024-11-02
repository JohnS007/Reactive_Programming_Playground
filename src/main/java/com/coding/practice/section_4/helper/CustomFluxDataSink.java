package com.coding.practice.section_4.helper;

import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class CustomFluxDataSink<T> implements Consumer<FluxSink<T>> {

    private FluxSink<T> mySink;

    @Override
    public void accept(FluxSink<T> fluxSink) {
        mySink = fluxSink;
    }

    public void print(T data){
        mySink.next(data);
    }

}
