package com.coding.practice.section_2.assignment;

import com.coding.practice.common.Util;

public class AssignmentRunnner {
    public static void main(String[] args) {

        var fileService = new FileServiceImpl();

        fileService.write("john.txt", "This is a test")
                        .subscribe(Util.subscriber());

        fileService.read("john.txt")
                .subscribe(Util.subscriber());

//        fileService.delete("john.txt")
//                        .subscribe(Util.subscriber());


        //Util.sleepSeconds(3);
    }
}
