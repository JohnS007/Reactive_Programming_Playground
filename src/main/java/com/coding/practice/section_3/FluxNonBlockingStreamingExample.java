package com.coding.practice.section_3;

import com.coding.practice.common.Util;
import com.coding.practice.section_3.client.ExternalServiceClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;

public class FluxNonBlockingStreamingExample {
    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        client.getNames()
                .subscribe(Util.subscriber("Subscriber-1"));

        client.getNames()
                .subscribe(Util.subscriber("Subscriber-2"));

        //Need to sleep the main thread to capture the final result
        Util.sleepSeconds(6);

    }
}
