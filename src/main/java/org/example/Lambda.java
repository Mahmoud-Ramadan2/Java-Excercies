package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Lambda {


    public static  int[] array = IntStream.rangeClosed(0,200).toArray();

    public static int total = Arrays.stream(array).sum();
    public static int a = IntStream.range(3,6).sum();
}

