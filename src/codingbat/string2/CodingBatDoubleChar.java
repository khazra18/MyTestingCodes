package codingbat.string2;

public class CodingBatDoubleChar {
    public static void main(String[] args) {
        /*Given a string, return a string where for every char in the original, there are two chars.


                doubleChar("The") → "TThhee"
        doubleChar("AAbb") → "AAAAbbbb"
        doubleChar("Hi-There") → "HHii--TThheerree"*/

        System.out.println(doubleChar("Hi-There"));
    }

    static String doubleChar(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < str.length() ;i++){
            builder.append(str.charAt(i)).append(str.charAt(i));
        }
        return builder.toString();
    }

}
