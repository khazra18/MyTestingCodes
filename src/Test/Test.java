package Test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>(Arrays.asList(5,4,6,1,3,2,7));
        System.out.println(myList);

        Iterator<Integer> itr = myList.iterator();
        for (int i = 0 ; i < myList.size() ; i++){
            Integer temp = itr.next();
            if (temp == 1){
                itr.remove();
            }
        }

        List<Integer> sortedList = myList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(sortedList);

    }

}
