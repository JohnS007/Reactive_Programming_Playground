package com.coding.practice.section_4;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        IntStream.rangeClosed(0, args.length-1).forEach(itr -> {
            //
        });
    }

    class Solution {
        public String largestNumber(int[] nums) {
            Arrays.stream(nums)
                    .mapToObj(number -> String.valueOf(number))
                    .sorted(String::compareTo)
                    .collect(Collectors.toList());
            return "";
        }
    }
}
