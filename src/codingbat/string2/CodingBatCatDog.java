package codingbat.string2;

public class CodingBatCatDog {
    public static void main(String[] args) {

        /*Return true if the string "cat" and "dog" appear the same number of times in the given string.


        catDog("catdog") → true
        catDog("catcat") → false
        catDog("1cat1cadodog") → true*/

        System.out.println(catDog("1ca1cadodog"));
    }

    static boolean catDog(String str) {
        int countCat = 0;
        int countDog = 0;
        for (int i = 0; i < str.length()-2; i++) {
            if (str.charAt(i)=='c' && str.charAt(i+1)=='a' && str.charAt(i+2)=='t')
                countCat++;
            else if (str.charAt(i)=='d' && str.charAt(i+1)=='o' && str.charAt(i+2)=='g')
                countDog++;
        }
        return countCat == countDog;
    }

}
