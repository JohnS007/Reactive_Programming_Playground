//package com.coding.practice.section_4.assignment;
//
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.SynchronousSink;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//public class FileReaderServiceImpl2 implements FileReaderService{
//    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FileReaderServiceImpl2.class);
//
//    @Override
//    public Flux<String> read(Path path) {
//        return Flux.generate(
//                () -> getBufferedReaderForFile(path),
//                (reader, sink) -> readFile(reader, sink)
//        );
//    }
//
////    private BufferedReader readFile(BufferedReader reader, SynchronousSink<String> sink) {
////        try{
////            var line = reader.readLine();
////            log.info("Reading line");
////
////        }
////        catch (Exception e){
////
////        }
////    }
//
//    private BufferedReader getBufferedReaderForFile(Path path) {
//        try {
//            return Files.newBufferedReader(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//}
