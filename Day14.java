import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day14 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day14.txt");
        part1(file);
        // part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String tmplte = scan.nextLine();
        scan.nextLine();
        Map<String, Character> map = new HashMap<>();
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" -> ");
            map.put(line[0], line[1].charAt(0));
        }
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder(tmplte);
            for (int j = 1; j < tmplte.length(); j++) {
                char nn = map.get(tmplte.substring(j - 1, j + 1));
                sb.insert(j + j - 1, nn);
            }
            tmplte = sb.toString();
        }
        System.out.println(tmplte.length());
        Map<Character, Integer> count = new HashMap<>();
        int max = 1;
        for (char c : tmplte.toCharArray()) {
            Integer val = count.get(c);
            if (val == null) {
                count.put(c, 1);
            } else {
                count.put(c, val + 1);
                max = Math.max(max, val + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int val : count.values()) {
            min = Math.min(min, val);
        }
        System.out.println(max + " - " + min + " = " + (max - min));
    }
}
