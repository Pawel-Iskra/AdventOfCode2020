package day01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReportRepair {

    public static void main(String[] args) throws IOException {

        File input = new File("src/main/java/day01/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));

        List<Integer> numbers = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            int number = Integer.parseInt(line.strip());
            numbers.add(number);
        }
        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            int nr1 = numbers.get(i);
            for (int j = i + 1; j < size - 1; j++) {
                int nr2 = numbers.get(j);
                if ((nr1 + nr2) == 2020) {
                    System.out.println("Part 1 = " + (nr1 * nr2));
                }
                for (int k = j + 1; k < size - 2; k++) {
                    int nr3 = numbers.get(k);
                    if ((nr1 + nr2 + nr3) == 2020) {
                        System.out.println("Part 2 = " + (nr1 * nr2 * nr3));
                    }
                }
            }
        }
    }


}