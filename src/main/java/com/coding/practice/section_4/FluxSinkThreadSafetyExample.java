package com.coding.practice.section_4;

import com.coding.practice.common.Util;
import com.coding.practice.section_4.helper.NameFluxSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class FluxSinkThreadSafetyExample {

    private static final Logger log = LoggerFactory.getLogger(FluxSinkThreadSafetyExample.class);

    public static void main(String[] args) {
        fluxSinkDemo();
    }


    //Demonstrating that arrayList by default is not thread safe..
    private static void arrayListDemo(){
        //Create a array list to store the data
        var list = new ArrayList<>();

        //Create a runnable task which will have the logic to be executed when run...
        Runnable runnable = () -> {
            IntStream.rangeClosed(1, 1000).forEach(list::add);
        };

        //Creating some threads to work upon the task created above
        IntStream.rangeClosed(1, 10).forEach(itr -> {
            Thread thread = new Thread(runnable);
            thread.start();
        });

        //Need to block the thread for the task to be executed
        log.info("Blocking the thread for task to be executed: {}", Thread.currentThread().getName());
        Util.sleepSeconds(5);

        //Checking the results after execution of threads
        log.info("Size of list: {}", list.size());
    }


    /*

        Upon subscription and calls for request, FluxSink will receive the data
        from all the threads and will sequential pass on the data to the subscriber -

     */
    private static void fluxSinkDemo(){
        //Create a array list to store the data
        var list = new ArrayList<>();

        //Creating a fluxSink with custom implementation
        var nameFluxSink = new NameFluxSink();
        var flux = Flux.create(nameFluxSink);
        flux.subscribe(list::add); //Need to add the names to list upon subscription !!

        //Create a runnable task which will have the logic to be executed when run...
        Runnable runnable = () -> {
            IntStream.rangeClosed(1, 1000).forEach(itr -> nameFluxSink.generateName());
        };

        //Creating some threads to work upon the task created above
        IntStream.rangeClosed(1, 10).forEach(itr -> {
            Thread thread = new Thread(runnable);
            thread.start();
        });

        //Need to block the thread for the task to be executed
        log.info("Blocking the thread for task to be executed: {}", Thread.currentThread().getName());
        Util.sleepSeconds(5);

        //Checking the results after execution of threads
        log.info("Size of list: {}", list.size());


    }
}
