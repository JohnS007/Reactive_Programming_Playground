package com.coding.practice.section_2.client;

import com.coding.practice.common.AbstractHttpClient;
import reactor.core.publisher.Mono;

public class ExternalServiceClient extends AbstractHttpClient {

    //Need to create a publisher to access the external resource by subscribing to it
    public Mono<String> getProductName(int productId){
        //Directly invoke the endpoint for getting the product name
        return this.httpClient
                .get()
                .uri("/demo01/product/" + productId)
                .responseContent()  //ByteBuffFlux to get the result as stream of ByterBuffer which can be serialized to any object of our choice
                .asString()
                .next();
    }
}
