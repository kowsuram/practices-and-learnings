package io.kowsu.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
    @created March/27/2024 - 3:48 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
public class ReverseMapByValues {
    public static void main(String[] args) {
        Map<String, Person> map = new HashMap<>();
        Map<String, Person> res = new LinkedHashMap<>();
        map.put("A1", new Person("Zero", 0));
        map.put("D1", new Person("Three", 3));
        map.put("C1", new Person("Two", 2));
        map.put("B1", new Person("One", 1));

        ArrayList<Map.Entry<String, Person>> entries = new ArrayList(map.entrySet());

        Collections.sort(entries, (o1, o2) -> o1.getValue().id() > o2.getValue().id() ? 1 : -1);

        entries.forEach(e -> res.put(e.getKey(), e.getValue()));

        System.out.println(res);
    }
}

record Person(String name, int id) {
}
