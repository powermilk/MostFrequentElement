package com.powermilk;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentElement {

    public List<String> getMostFrequentElement(int[] array) {

        Map<Integer, Long> count = Arrays
                .stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> frequent = new ArrayList<>() ;

        for (Map.Entry<Integer,Long> e : count.entrySet() ) {
            if (e.getValue().equals(Collections.max(count.values()))){
                frequent.add(e.getKey() + "x" + e.getValue()) ;
            }
        }

        return frequent;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 5, 5, 6, 6, 6, 7, 7};
        MostFrequentElement mostFrequentElement = new MostFrequentElement();
        System.out.println(mostFrequentElement.getMostFrequentElement(array));
    }
}
