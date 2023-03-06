package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SortZeroAndOne {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(0,1,0,1,0,1,1,1,0,0,1,0,1));
        ArrayList<Integer> sortedList = new ArrayList<>();

        for (Integer integer : myList) {
            if (integer == 0) {
                sortedList.add(0, integer);
            } else {
                sortedList.add(integer);
            }
        }

        System.out.println(sortedList);

    }

}
