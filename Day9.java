import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day9 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day9.txt");
        part1(file);
        // part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<List<Integer>> table = new ArrayList<>();
        while (scan.hasNextLine()) {
            List<Integer> row = new ArrayList<>();
            String line = scan.nextLine();
            for (char ch : line.toCharArray()) {
                row.add(Character.getNumericValue(ch));
            }
            table.add(row);
        }
        int lowPoints = 0;
        int width = table.get(0).size();
        int height = table.size();

        // Check corners
        int leftUpper = table.get(0).get(0);
        int rightUpper = table.get(0).get(width - 1);
        int leftLower = table.get(height - 1).get(0);
        int rightLower = table.get(height - 1).get(width - 1);
        if (leftUpper < table.get(0).get(1) && leftUpper < table.get(1).get(0)) {
            lowPoints += leftUpper + 1;
        }
        if (rightUpper < table.get(0).get(width - 2) && rightUpper < table.get(1).get(width - 1)) {
            lowPoints += rightUpper + 1;
        }
        if (leftLower < table.get(height - 2).get(0) && leftLower < table.get(height - 1).get(1)) {
            lowPoints += leftLower + 1;
        }
        if (rightLower < table.get(height - 2).get(width - 1) && rightLower < table.get(height - 1).get(width - 2)) {
            lowPoints += rightLower + 1;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                try {
                    // if ((i==0 && j==0) || (i==height-1 || j==width-1)) {
                    // continue;
                    // }
                    if (i > 0 && j > 0 && j < width-1 && i < height - 1) {
                        if (table.get(i).get(j) < table.get(i - 1).get(j)
                                && table.get(i).get(j) < table.get(i + 1).get(j)
                                && table.get(i).get(j) < table.get(i).get(j - 1)
                                && table.get(i).get(j) < table.get(i).get(j + 1)) {
                            lowPoints += table.get(i).get(j) + 1;
                        }
                    } else if (i == 0 && j > 0 && j < width - 1) {
                        int point = table.get(0).get(j);
                        if (point < table.get(0).get(j + 1)
                                && point < table.get(0).get(j - 1)
                                && point < table.get(1).get(j)) {
                            lowPoints += point + 1;
                        }
                    } else if (i == height - 1 && j > 0 && j < width - 1) {
                        int point = table.get(i).get(j);
                        if (point < table.get(i).get(j + 1)
                                && point < table.get(i).get(j - 1)
                                && point < table.get(i - 1).get(j)) {
                            lowPoints += point + 1;
                        }
                    } else if (j == 0 && i > 0 && i < height - 1) {
                        int point = table.get(i).get(0);
                        if (point < table.get(i + 1).get(0)
                                && point < table.get(i - 1).get(0)
                                && point < table.get(i).get(j + 1)) {
                            lowPoints += point + 1;
                        }
                    } else if (j == width - 1 && i > 0 && i < height - 1) {
                        int point = table.get(i).get(j);
                        if (point < table.get(i + 1).get(j)
                                && point < table.get(i - 1).get(j)
                                && point < table.get(i).get(j - 1)) {
                            lowPoints += point + 1;
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(lowPoints);
    }
}
