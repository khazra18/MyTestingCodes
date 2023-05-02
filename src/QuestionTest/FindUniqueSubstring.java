package QuestionTest;

import java.util.*;

public class FindUniqueSubstring {

    public static void main(String[] args) {

        String s = "aaaabbcdeeeefggghijk";
        System.out.println(longestSubstring(s));

    }

    public static String longestSubstring(String s) {
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(c);
            if (i - start > end - start) {
                end = i;
            }
        }
        return s.substring(start, end+1);
    }


}
