package com.coding.practice.section_2;

import com.coding.practice.common.Util;
import com.coding.practice.section_2.client.ExternalServiceClient;

import java.util.stream.IntStream;

public class NonBlockingIOExample {
    public static void main(String[] args) {

        var externalServiceClient = new ExternalServiceClient();

        IntStream.rangeClosed(1, 100).forEach((id) -> externalServiceClient.getProductName(id)
                .subscribe(Util.subscriber()));

        Util.sleepSeconds(2);
    }
}
