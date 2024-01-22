package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI24 {
    static public void main(String argv[]){
        int[] arr = { 120,50, 60, 70, 80, 90, 100, 110};
        int count = 0;
        for (int x : arr) {
            if (x >= 90) continue;
            x += 10;
            count++;
            if (count > 3) break;
            System.out.println(x);
        }

        IntStream.of(50, 60, 70, 80, 90, 100, 110, 120).filter(x -> x < 90).map(x -> x + 10)
                .limit(3).forEach(System.out::println);


        List<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
        Stream stream = list.stream();
        stream.filter(x-> x.toString().length() == 3).forEach(System.out::println);
    }
}
