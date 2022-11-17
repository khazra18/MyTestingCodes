package leetcode;

public class PalindromeQ9 {

    public static void main(String[] args) {

        System.out.println(isPalindrome(-10));
    }

    public static boolean isPalindrome(int x) {

        if (x < 0) return false;

        int sum = 0;
        int mainVar = x;
        for (int i = String.valueOf(mainVar).length() - 1; i >= 0; i--) {

            int temp = mainVar % 10;
            sum = sum + (temp * (int) Math.pow(10, i));
            mainVar = mainVar / 10;

            System.out.println("Temp: " + temp + " - Sum: " + sum + " - Mainvar: " + mainVar + " - valueOF i : " + i);

        }
        return x == sum;
    }

}
