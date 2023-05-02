package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RandomExamples {

    public static void main(String[] args) {


    }

    static void methodRemoveFromHashMap() {
        HashMap<String, Integer> myHashMap = new HashMap<>();
        myHashMap.put("book1", 50);
        myHashMap.put("book2", 75);
        myHashMap.put("book3", 100);
        myHashMap.put("book4", 110);
        myHashMap.put("book5", 120);

        myHashMap.entrySet().stream().filter(o -> o.getValue() > 100).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .entrySet().forEach(System.out::println);

    }
}
