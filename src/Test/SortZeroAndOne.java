package Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SortZeroAndOne {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(0,1,0,1,0,1,1,1,0,0,1,0,1));
        ArrayList<Integer> sortedList = new ArrayList<>();

        for (int i = 0 ; i < myList.size() ; i++){
            if (myList.get(i)==0){
                sortedList.add(0,myList.get(i));
            }else {
                sortedList.add(myList.get(i));
            }
        }

        System.out.println(sortedList);

    }

}
