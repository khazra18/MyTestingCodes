package codewars;

public class TidyNumber {
    public static void main(String[] args) {
        //https://www.codewars.com/kata/5a87449ab1710171300000fd/train/java


    }

    public static boolean tidyNumber(int number) {

        String[] s = String.valueOf(number).split("");
        for (int i = 0; i < s.length - 1; i++) {
            int a = Integer.parseInt(s[i]);
            int b = Integer.parseInt(s[i + 1]);
            if (b < a) return false;
        }
        return true;
    }
}
