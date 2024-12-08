import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CombinationGenerator {
    public static void main(String[] args) {
        // Generate all 4-digit numbers from 0000 to 9999
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            numbers.add(String.format("%04d", i));
        }

        // Generate all two-letter combinations from 'aa' to 'zz'
        List<String> letters = new ArrayList<>();
        for (char first = 'a'; first <= 'z'; first++) {
            for (char second = 'a'; second <= 'z'; second++) {
                letters.add("" + first + second);
            }
        }

        // Write combinations to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("combinations.txt"))) {
            for (String num : numbers) {
                for (String letter : letters) {
                    writer.write(num + "." + letter);
                    writer.newLine();
                }
            }
            System.out.println("Combinations have been written to combinations.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

