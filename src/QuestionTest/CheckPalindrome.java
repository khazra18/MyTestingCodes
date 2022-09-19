package QuestionTest;

import java.util.HashMap;
import java.util.Map;

public class CheckPalindrome {


    public static void main(String[] args) {
        String text1 = "aabaacd";
        String text2 = "aabaacdaa";
        String text3 = "aabaa";
        String text4 = "aabaacddasda";
        String text5 = "scpcyxprxxsjyjrww";
        String text6 = "aabbccc";


        //System.out.println(checkOddCount(text5));
        System.out.println(minSwaps(text5));


    }

    static boolean checkOddCount(String value){

        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0 ; i < value.length() ; i++){
            Character val = value.charAt(i);
            if (map.containsKey(val)){
                map.put(val,map.get(val)+1);
            } else  {
                map.put(val,1);
            }
        }

        System.out.println(map);

        int count = 0;
        for (Map.Entry<Character,Integer> tempVal : map.entrySet()){
            int temp = tempVal.getValue();
            if (temp % 2 != 0){
                count++;
            }
        }
        return count <= 1;
    }

    public static int minSwaps(String inp) {

        int n = inp.length();
        char s[] = inp.toCharArray();
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            int left = i;
            int right = n - left - 1;
            while (left < right) {
                if (s[left] == s[right]) {
                    break;
                } else {
                    right--;
                }
            }
            if (left == right) {
                // s[left] is the character in the middle of the palindrome
                char t = s[left];
                s[left] = s[left + 1];
                s[left + 1] = t;
                count++;
                i--;
            } else {
                for (int j = right; j < n - left - 1; j++) {
                    char t = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = t;
                    count++;
                }
            }
        }
        return count;
    }

}


