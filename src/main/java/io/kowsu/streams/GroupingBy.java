package io.kowsu.streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    @created April/05/2024 - 3:16 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class GroupingBy {

    public static void groupNumbers(List<Integer> integers) {
        Map<Integer, Long> collect = integers.stream().collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        ));
        System.out.println(collect);
    }


    public static void groupPercentages(List<Integer> percentages) {
        Map<Integer, Long> collect = percentages.stream()
                .collect(Collectors.groupingBy(k -> k / 10, Collectors.counting()));
        System.out.println(collect);
    }

    //aaabbccdddeaa
    //a3b2c2d3e1a2
    public static String sequencePrinting(String word) {
        int length = word.length();
        char[] chars = word.toCharArray();
        StringBuffer buff = new StringBuffer();
        int i, res = 0;
        for (i = res; i < length; ) {
            char ch = chars[i];
            int counter = 0;
            for (int j = i; j < length; j++) {
                if (ch != chars[j]) {
                    res = j;
                    break;
                } else {
                    counter++;
                }
            }
            buff.append(String.valueOf(ch) + "" + counter);
        }
        return buff.toString();
    }


    public static String sequencePrintingWithHm(String word) {
        int length = word.length();
        char[] chars = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        StringBuffer buff = new StringBuffer();
        char prev = 0;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else if (map.size() > 0) {
                buff.append(prev + "" + map.get(prev));
                map.clear();
                map.put(chars[i], 1);
                prev = chars[i];
            } else {
                map.put(chars[i], 1);
                prev = chars[i];
            }
        }
        buff.append(prev + "" + map.get(prev));
        return buff.toString();
    }


    //aaabbccdddeaa
    public static String sequencePrintingWithSingleLoop(String word) {
        int length = word.length();
        StringBuffer res = new StringBuffer();
        char prev = word.charAt(0), curr;
        int counter = 1;
        for (int i = 1; i < length; i++) {
            curr = word.charAt(i);
            if (prev != curr) {
                res.append(prev);
                res.append(counter);
                counter = 1;
                prev = curr;
            } else {
                counter++;
            }
        }
        res.append(prev);
        res.append(counter);
        return res.toString();
    }


    public static String frequencyCounter(String word,
                                          int index,
                                          int counter, char prev, StringBuffer res) {
        if (index < word.length()) {
            char curr = word.charAt(counter);
            if (prev != curr) {
                res.append(prev);
                res.append(counter);
                counter = 1;
                prev = curr;
                index++;
            } else {
                counter++;
                index++;
            }
            frequencyCounter(word, index, counter, prev, res);
        }
        return res.toString();
    }


    public static void main(String[] args) {
//        groupNumbers(Arrays.asList(1,2,1,3,1,3,2,1));
//        groupPercentages(Arrays.asList(9, 12, 12, 15, 78, 43, 23));
//        System.out.println(sequencePrinting("aaabbccdddeaa"));
//        System.out.println(sequencePrintingWithHm("Hello world"));
//        System.out.println(sequencePrintingWithSingleLoop("aaabbccdddeaa"));
        System.out.println(frequencyCounter("aaabbccdddeaa", 1,
                1, 'a', new StringBuffer()));
    }
}
