import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day11 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day11.txt");
        part1(file);
        // part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
        }
    }
}
