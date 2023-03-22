package Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class OddNumbersGenerator {
    public static void main(String[] args) throws IOException {
        String filename = "numbers.txt"; // replace with the name of your output file
        int numLines = 10000000;
        int maxNumber = 1000000; // maximum odd number to generate
        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < numLines; i++) {
                int n;
                do {
                    n = rand.nextInt(maxNumber) + 1;
                } while (n % 2 == 0);
                writer.write(Integer.toString(n));
                writer.newLine();
            }
        }
    }
}