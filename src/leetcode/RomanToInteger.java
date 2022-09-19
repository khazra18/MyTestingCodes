package leetcode;

import java.util.*;

public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println("Please input a roman numeral");
        Scanner scanner = new Scanner(System.in);
        String userGivenText = scanner.nextLine().toUpperCase();
        if (!checkStringLength(userGivenText)) {
            System.out.println("Please give a string value length range between 1 to 15");
        } else if (!checkIfStringContainsRomanCharOrNot(userGivenText)) {
            System.out.println("Please give a proper roman numerals");
        } else {
            int value = getIntegerNumberFromRomanNumerals(userGivenText);
            System.out.println(value);
        }
    }

    private static int getIntegerNumberFromRomanNumerals(String userGivenText) {

        HashMap<String, Integer> map = new HashMap<>(getRomanValues());
        char[] romanChar = userGivenText.toCharArray();
        int total = 0;
        for (int i = 0; i < romanChar.length; i++) {
            if ((romanChar[i] == 'V' || romanChar[i] == 'X') && i != 0) {
                if (romanChar[i - 1] == 'I') {
                    if (romanChar[i] == 'V')
                        total = (total - 1) + 4;
                    else
                        total = (total - 1) + 9;
                } else {
                    int value = map.get(String.valueOf(romanChar[i]));
                    total = total + value;
                }
            } else if ((romanChar[i] == 'L' || romanChar[i] == 'C') && i != 0) {
                if (romanChar[i - 1] == 'X') {
                    if (romanChar[i] == 'L')
                        total = (total - 10) + 40;
                    else total = (total - 10) + 90;
                } else {
                    int value = map.get(String.valueOf(romanChar[i]));
                    total = total + value;
                }
            } else if ((romanChar[i] == 'D' || romanChar[i] == 'M') && i != 0) {
                if (romanChar[i - 1] == 'C') {
                    if (romanChar[i] == 'D')
                        total = (total - 100) + 400;
                    else total = (total - 100) + 900;
                } else {
                    int value = map.get(String.valueOf(romanChar[i]));
                    total = total + value;
                }
            } else {
                int value = map.get(String.valueOf(romanChar[i]));
                total = total + value;
            }
        }

        return total;
    }

    static boolean checkStringLength(String s) {
        return s.length() >= 1 && s.length() <= 15;
    }

    static boolean checkIfStringContainsRomanCharOrNot(String text) {

        ArrayList<String> romanCharList = new ArrayList<>(Arrays.asList("I", "V", "X", "L", "C", "D", "M"));
        char[] ch = text.toCharArray();
        for (char ch1 : ch) {
            if (!romanCharList.contains(String.valueOf(ch1).toUpperCase()))
                return false;
        }
        return true;
    }

    static HashMap<String, Integer> getRomanValues() {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        return map;
    }

}
