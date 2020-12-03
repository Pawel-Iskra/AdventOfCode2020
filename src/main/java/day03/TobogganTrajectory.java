package day03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TobogganTrajectory {

    private static int getNumberOfTrees(int xChange, int yChange, List<String> slope) {
        int treeCounter = 0;
        int width = slope.get(0).length();
        int hight = slope.size();
        int x = 0;
        int y = 0;
        while (y < hight) {
            String row = slope.get(y);
            if (row.charAt(x) == '#') {
                treeCounter++;
            }
            y = y + yChange;
            x = (x + xChange) % width;
        }
        return treeCounter;
    }

    public static void main(String[] args) throws IOException {

        File input1 = new File("src/main/java/day03/input.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(input1));
        List<String> slope = new ArrayList<>();
        String line;
        while ((line = br1.readLine()) != null) {
            slope.add(line);
        }

        File input2 = new File("src/main/java/day03/changes.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(input2));
        int[][] changes = new int[5][2];
        for (int i = 0; i < 5; i++) {
            line = br2.readLine();
            String[] halfs = line.split(",");
            int xChange = Integer.parseInt(halfs[0].replaceAll("[^0-9]", ""));
            int yChange = Integer.parseInt(halfs[1].replaceAll("[^0-9]", ""));
            changes[i][0] = xChange;
            changes[i][1] = yChange;
        }

        long answerForPart2 = 1L;
        for (int i = 0; i < 5; i++) {
            int numberOfTrees = getNumberOfTrees(changes[i][0], changes[i][1], slope);
            if (i == 1) {
                System.out.println("Part1 = " + numberOfTrees);
            }
            answerForPart2 *= numberOfTrees;
        }
        System.out.println("Part2 = " + answerForPart2);

    }
}