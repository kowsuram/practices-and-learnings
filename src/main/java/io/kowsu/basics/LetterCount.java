package io.kowsu.basics;

import java.util.HashMap;
import java.util.Map;

/*
    @created April/04/2024 - 2:45 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class LetterCount {

    public String letterCount(String abc) {
        char[] ch = abc.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if(map.containsKey(ch[i])) {
                map.put(ch[i], map.get(ch[i])+1);
            }else {
                map.put(ch[i], 1);
            }
        }
        map.forEach((x,y) -> {
            stringBuffer.append(x+ "" + y);
        });
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        LetterCount count = new LetterCount();
        System.out.println(count.letterCount("aaabbccdde"));
    }
}
