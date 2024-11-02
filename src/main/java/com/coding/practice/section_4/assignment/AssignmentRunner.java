package com.coding.practice.section_4.assignment;

import com.coding.practice.common.Util;
import com.coding.practice.section_1.subscriber.SubscriberImpl;
import reactor.core.publisher.Flux;

import java.nio.file.Path;

public class AssignmentRunner {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AssignmentRunner.class);
    public static void main(String[] args) {

        var flux = new FileReaderServiceImpl().read(Path.of("john.txt"));
        var subscriber = new SubscriberImpl();
        flux.subscribe(subscriber);

        subscriber.getSubscription().request(10);



    }
}
