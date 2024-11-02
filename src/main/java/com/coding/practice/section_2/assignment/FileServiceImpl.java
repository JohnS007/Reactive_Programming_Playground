package com.coding.practice.section_2.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    This is quite verbose and not the better implementation
 */


public class FileServiceImpl implements FileService{

    public static final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public Mono<String> read(String filename) {
        log.info("Reading from the file: {}", filename);
        Path filePath = Paths.get(filename);

        try{
            if(!Files.exists(filePath)){
                Files.createFile(filePath);
                write(filename, "");
            }
            return Mono.fromCallable(() -> Files.readAllLines(filePath).stream().reduce("", String::concat));

        } catch (IOException e) {
            return Mono.fromRunnable(()->notifyException(e));
        }

    }


    @Override
    public Mono<Void> write(String filename, String content) {
        log.info("Writing to file: {}", filename);
        log.info("Content to be written: {}", content);
        Path filePath = Paths.get(filename);
        try{

            if(!Files.exists(filePath)){
                Files.createFile(filePath);
                Files.write(filePath, Arrays.asList("This is the creation of file"), StandardOpenOption.APPEND);
            }

            List<String> contentList = Arrays.asList(content);
            Files.write(filePath, contentList, StandardOpenOption.APPEND);
            return Mono.empty();

        } catch (IOException e) {
            return Mono.fromRunnable(()->notifyException(e));
        }

    }

    @Override
    public Mono<Void> delete(String filename) {
        log.info("Deleting the file: {}", filename);
        Path filePath = Paths.get(filename);
        try {
            Files.delete(filePath);
            return Mono.empty();
        } catch (IOException e) {
            return Mono.fromRunnable(()->notifyException(e));
        }
    }

    private void notifyException(Exception e) {
        log.info("Received exception while working on the files: {}", e.toString());
    }
}

