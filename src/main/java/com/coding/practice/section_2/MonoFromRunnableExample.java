package com.coding.practice.section_2;

import com.coding.practice.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class MonoFromRunnableExample {

    private static final Logger log = LoggerFactory.getLogger(MonoFromRunnableExample.class);

    public static void main(String[] args) {

        getProductName(2)
                .subscribe(Util.subscriber());

    }
    private static Mono<String> getProductName(int productId){
        if(productId == 1){
            return Mono.fromSupplier(()-> Util.faker().commerce().productName());
        }
        return Mono.fromRunnable(()->notifyOutOfStock(productId));
    }

    private static void notifyOutOfStock(int productId) {
        log.info("Notifying business out of stock for the productId: {}", productId);
    }
}
