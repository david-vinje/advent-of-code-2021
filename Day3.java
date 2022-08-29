import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day3.txt");
        part1(file);
        part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int n = "111100000101".length();
        int[] zeros = new int[n];
        int[] ones = new int[n];
        while (scan.hasNextLine()) {
            char[] line = scan.nextLine().toCharArray();
            for (int i = 0; i < line.length; i++) {
                if (Character.getNumericValue(line[i]) == 0)
                    zeros[i]++;
                else
                    ones[i]++;
            }
        }
        scan.close();
        String eps = "", gam = "";
        for (int i = 0; i < n; i++) {
            gam += zeros[i] > ones[i] ? 0 : 1;
            eps += zeros[i] > ones[i] ? 1 : 0;
        }
        int res = Integer.parseInt(eps, 2) * Integer.parseInt(gam, 2);
        System.out.println(res);
    }

    public static void part2(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<String> bits = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            bits.add(line);
        }
        int n = bits.get(0).length();
        List<String> generator = new ArrayList<>(bits);
        List<String> scrubber = new ArrayList<>(bits);
        for (int i = 0; i < n; i++) {
            if (scrubber.size() > 1) {
                scrubber = scrub(scrubber, i);
            }
            if (generator.size() > 1) {
                generator = gen(generator, i);
            }
        }
        int res = Integer.parseInt(scrubber.get(0), 2) * Integer.parseInt(generator.get(0), 2);
        System.out.println(res);
    }

    public static List<String> scrub(List<String> scrubber, int pos) {
        int zeros = 0, ones = 0;
        for (String s : scrubber) {
            if (Character.getNumericValue(s.charAt(pos)) == 0)
                zeros++;
            else
                ones++;
        }
        int i = zeros <= ones ? 0 : 1;
        List<String> tmp = new ArrayList<>(scrubber);
        for (String s : scrubber) {
            if (Character.getNumericValue(s.charAt(pos)) != i) {
                tmp.remove(s);
                if (tmp.size() == 1)
                    return tmp;
            }
        }
        return tmp;
    }

    public static List<String> gen(List<String> scrubber, int pos) {
        int zeros = 0, ones = 0;
        for (String s : scrubber) {
            if (Character.getNumericValue(s.charAt(pos)) == 0)
                zeros++;
            else
                ones++;
        }
        int i = zeros > ones ? 0 : 1;
        List<String> tmp = new ArrayList<>(scrubber);
        for (String s : scrubber) {
            if (Character.getNumericValue(s.charAt(pos)) != i) {
                tmp.remove(s);
                if (tmp.size() == 1)
                    return tmp;
            }
        }
        return tmp;
    }
}
