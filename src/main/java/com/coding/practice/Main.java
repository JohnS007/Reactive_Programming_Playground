package com.coding.practice;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        int[] arr =  new int[]{1, 3, 4, 5, 6};

        Arrays.stream(arr)
                .boxed()
                .filter(num -> num % 2 == 0)
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        long sum = Arrays.stream(arr).mapToLong(num -> (num)).reduce(0, Long::sum);

        int[][] grid = new int[][]{{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}};

        long gridSum = Arrays.stream(grid)
                .flatMap(row -> Arrays.stream(row).boxed())
                .reduce(0, Integer::sum);
    }
}