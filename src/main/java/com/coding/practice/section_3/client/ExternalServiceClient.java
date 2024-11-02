package com.coding.practice.section_3.client;

import com.coding.practice.common.AbstractHttpClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {

    //Need to create a publisher to access the external resource by subscribing to it

    public Flux<String> getNames(){
        //Directly invoke the endpoint for getting names every 500 ms as per the service behavior we know
        return this.httpClient
                .get()
                .uri("/demo02/name/stream")
                .responseContent()  //ByteBuffFlux to get the result as stream of ByterBuffer which can be serialized to any object of our choice
                .asString();
    }

    public Flux<Integer> getStockPrices(){
        //Directly invoke the endpoint for getting stock prices every 500 ms as per the service behavior we know
        return this.httpClient
                .get()
                .uri("/demo02/stock/stream")
                .responseContent()  //ByteBuffFlux to get the result as stream of ByterBuffer which can be serialized to any object of our choice
                .asString()
                .map(Integer::parseInt);
    }
}
