package examples;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class SortHashMap {

    public static void main(String[] args) {

        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);

        System.out.println(sortHashMap(budget));

    }

    static Map<String, Integer> sortHashMap(Map<String, Integer> myMap) {

        List<Map.Entry<String, Integer>> myList = new ArrayList<>(myMap.entrySet());
        List<Map.Entry<String, Integer>> collect = myList.stream().sorted(comparingByValue()).collect(Collectors.toList());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        collect.forEach(o -> sortedMap.put(o.getKey(), o.getValue()));

        return sortedMap;

        //myMap.entrySet().stream().sorted(comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e2,LinkedHashMap::new));


    }

}
