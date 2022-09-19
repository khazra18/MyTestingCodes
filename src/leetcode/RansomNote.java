package leetcode;

public class RansomNote {

    public static void main(String[] args) {

        StringBuilder rasomnote = new StringBuilder("aabc");
        rasomnote.deleteCharAt(rasomnote.indexOf("b"));
        System.out.println(rasomnote);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        return false;
    }

}
