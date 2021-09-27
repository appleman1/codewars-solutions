package com.falkenberg.viktor.codewars.kata1;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(parseInt("seven hundred eighty-three thousand nine hundred and nineteen"));
    }

    public static int parseInt(String numStr) {
        Map<String, Integer> words = new HashMap<>() {{
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
            put("ten", 10);
            put("eleven", 11);
            put("twelve", 12);
            put("thirteen", 13);
            put("fourteen", 14);
            put("fifteen", 15);
            put("sixteen", 16);
            put("seventeen", 17);
            put("eighteen", 18);
            put("nineteen", 19);
            put("twenty", 20);
            put("thirty", 30);
            put("forty", 40);
            put("fifty", 50);
            put("sixty", 60);
            put("seventy", 70);
            put("eighty", 80);
            put("ninety", 90);
        }};
        Map<String, Integer> multiMap = Map.of(
                "hundred", 100,
                "thousand", 1000,
                "thous", 1000,
                "million", 1000000
        );
        String toLowerCase = numStr.toLowerCase()
                .replace("-", " ")
                .replace("and", "");
        List<String> strings = Arrays.stream(toLowerCase.split(" "))
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());
        int value=0;
        for (String word : strings) {
            if (words.get(word) != null) {
                value += words.get(word);
            };
            if (multiMap.get(word) != null){
                int i = multiMap.get(word) * (value % multiMap.get(word));
                int i1 = value % multiMap.get(word);
                value += i - i1;
            }
        }

        return 0;
    }
}
