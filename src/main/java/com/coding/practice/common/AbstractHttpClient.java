package com.coding.practice.common;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.LoopResources;

public abstract class AbstractHttpClient {
    public static final String BASE_URL = "http://localhost:7070";
    protected final HttpClient httpClient;

    public AbstractHttpClient() {

        //Here we will create our own custom HttpClient implementation for our demo

        //Need to have more control on the threads that's why loopResources is created
        //By default if we just create() the httpClient it will create 1 thread per cpu core we have
        //If we want to have more control on the number of threads and their working

        //LoopResources is basically a manager of EventLoopGroup and is used to create EventLoopGroup

        var loopResources = LoopResources.create("John", 1, true);

        this.httpClient = HttpClient.create()
                .runOn(loopResources)
                .baseUrl(BASE_URL);
    }
}
