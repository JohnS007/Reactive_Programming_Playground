package com.coding.practice.section_4.assignment;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FileReaderServiceImpl implements FileReaderService{
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FileReaderServiceImpl.class);

    @Override
    public Flux<String> read(Path path) {
        return Flux.create(fluxSink -> {
            fluxSink.onRequest(lines -> {
                if(!fluxSink.isCancelled()) {
                    LongStream.rangeClosed(1, lines).forEach(itr -> {
                        if(Files.exists(path)){
                            try {
                                String content = Files.readAllLines(path).stream().reduce("", String::concat);
                                fluxSink.next(content);
                            } catch (IOException exception) {
                                fluxSink.error(exception);
                            }
                        }
                        else{
                            fluxSink.error(new RuntimeException("No file found at given path"));
                        }
                    });
                }
            });
        });
    }
}
