package day02;

import java.io.*;
import java.util.Arrays;

public class PasswordPhilosophy {
    public static void main(String[] args) throws IOException {

        File input = new File("src/main/java/day02/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));

        int globalCounterPart1 = 0;
        int globalCounterPart2 = 0;

        int localCounter = 0;
        String line;
        while ((line = br.readLine()) != null) {
            localCounter = 0;
            String[] halfs = line.split(":");
            char letter = halfs[0].charAt(halfs[0].length() - 1);

            String[] validation = halfs[0].split(" ");
            String[] minMax = validation[0].split("-");

            int min = Integer.parseInt(minMax[0]);
            int max = Integer.parseInt(minMax[1]);

            String password = halfs[1];
            int len = password.length();
            for (int i = 0; i < len; i++) {
                if (password.charAt(i) == letter) {
                    localCounter++;
                }
            }
            if ((localCounter >= min) && (localCounter <= max)) {
                globalCounterPart1++;
            }

            localCounter = 0;
            if (password.charAt(min) == letter) localCounter++;
            if (password.charAt(max) == letter) localCounter++;
            if (localCounter == 1) {
                globalCounterPart2++;
            }

        }

        System.out.println("Part1 = " + globalCounterPart1);
        System.out.println("Part2 = " + globalCounterPart2);
    }
}
