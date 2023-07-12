package StringProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveAlternateElementFromArraylist {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i"));

        for (int i = stringList.size() - 1; i >= 0; i--) {
            if (i % 2 != 0) {
                stringList.remove(i);
            }
        }

        System.out.println(stringList);


        //--------------using java 8 ---------------

        List<String> stringList1 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i"));

        List<String> result = IntStream.range(0, stringList1.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(stringList1::get)
                .collect(Collectors.toList());

        System.out.println(result);


    }
}
