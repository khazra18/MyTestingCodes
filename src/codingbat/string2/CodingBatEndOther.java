package codingbat.string2;

public class CodingBatEndOther {
    public static void main(String[] args) {
        /*Given two strings, return true if either of the strings appears at the very end of the other string,
                ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
        Note: str.toLowerCase() returns the lowercase version of a string.


                endOther("Hiabc", "abc") → true
        endOther("AbC", "HiaBc") → true
        endOther("abc", "abXabc") → true*/

        System.out.println(endOther("abcXYZ", "abcDEF"));

    }

    static boolean endOther(String a, String b) {
        if (a.length() > b.length()){
            int subStrCount = b.length();
            String aSub = a.substring(a.length()-subStrCount);
            return aSub.equalsIgnoreCase(b);
        }else if (a.length() < b.length()){
            int subStrCount = a.length();
            String bSub = b.substring(b.length()-subStrCount);
            return bSub.equalsIgnoreCase(a);
        }else {
            return a.equalsIgnoreCase(b);
        }
    }
}
