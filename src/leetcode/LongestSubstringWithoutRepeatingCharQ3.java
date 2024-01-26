package leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharQ3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabca"));
    }

    public static int lengthOfLongestSubstring(String param) {

        LinkedHashMap<String,Integer> myList = new LinkedHashMap<>();
        List<String> str = Arrays.asList(param.split(""));
        System.out.println(str);
        int longestSubStringLength = 0;

        for (int i = 0 ; i< str.size() ; i++){

            if (!myList.containsKey(str.get(i))){
                myList.put(str.get(i),i);
            }else {
                longestSubStringLength = i;
                myList.clear();
            }



        }


        return 0;

    }

}
