package codewars;

import java.util.Arrays;
import java.util.Comparator;

public class SortByNameLength {

    public static void main(String[] args) {


        /*https://www.codewars.com/kata/5701800886306a876a001031/train/java

        Suzuki needs help lining up his students!

                Today Suzuki will be interviewing his students to ensure they are progressing in their training.
        He decided to schedule the interviews based on the length of the students name in descending order.
                The students will line up and wait for their turn.

        You will be given a string of student names. Sort them and return a list of names in descending order.*/

        String string = "Tadashi Takahiro Takao Takashi Takayuki Takehiko Takeo Takeshi Takeshi";

    }

    static String[] lineupStudents(String students) {

        String[] split = students.split(" ");

        Arrays.sort(split,(o1, o2) -> {
            int lengthCompare = Integer.compare(o2.length(),o1.length());
            if (lengthCompare == 0){
                return o2.compareTo(o1);
            }
            return lengthCompare;
        });

        return split;

        //optimized way
        /*return Stream.of(students.split(" "))
                .sorted(comparingInt(String::length).thenComparing(identity()).reversed())
                .toArray(String[]::new);*/
    }
}
