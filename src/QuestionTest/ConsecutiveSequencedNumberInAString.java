package QuestionTest;

public class ConsecutiveSequencedNumberInAString {

    public static void main(String[] args) {

    }

    static boolean isGivenStringHasConsecutiveSequencedNumber(String value){

        int givenStringLength = value.length();
        String firstCharOfGivenString = String.valueOf(value.charAt(0));

        int firstNumber = Integer.parseInt(firstCharOfGivenString);
        String newString = firstNumber + "" + (firstNumber+1) + "" + (firstNumber+2);

        return false;

    }

}
