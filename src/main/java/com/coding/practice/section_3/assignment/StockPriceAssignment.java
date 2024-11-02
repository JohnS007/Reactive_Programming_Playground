package com.coding.practice.section_3.assignment;

import com.coding.practice.common.Util;
import com.coding.practice.section_3.client.ExternalServiceClient;
import reactor.core.publisher.Flux;

public class StockPriceAssignment {
    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        var subscriber = new StockPricesObserver();

        client.getStockPrices().subscribe(subscriber);


        Util.sleepSeconds(20);

    }
}
