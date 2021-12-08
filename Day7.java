import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day7 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day7.txt");
        // part1(file);
        part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String[] line = scan.nextLine().split(",");
        int min = Integer.MAX_VALUE;
        for(String s : line) {
            int i = Integer.parseInt(s);
            int count = 0;
            for (String ss : line) {
                count += Math.abs(Integer.parseInt(ss)-i);
            }
            min = Math.min(min, count);
        }
        System.out.println(min);
    }

    public static void part2(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String[] line = scan.nextLine().split(",");
        int max = 0;
        for (String s : line) {
            max = Math.max(max, Integer.parseInt(s));
        }
        int min = Integer.MAX_VALUE;
        for (int k=0; k<=max; k++) {
            int cost = 0;
            for (String s : line) {
                int i = Integer.parseInt(s);
                int d = Math.abs(k-i);
                cost += d*(d+1)/2;
            }
            min = Math.min(min, cost);
        }
        System.out.println(min);
    }
}
