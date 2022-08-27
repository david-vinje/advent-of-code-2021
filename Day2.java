import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        File file = new File("day2.txt");
        part1(file); part2(file);
    }

    public static void part2(File file) {
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int h = 0, d = 0, aim = 0;
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" ");
            if (line[0].equals("forward")) {
                h += Integer.parseInt(line[1]);
                d += aim*Integer.parseInt(line[1]);
            } else if (line[0].equals("down")) {
                aim += Integer.parseInt(line[1]);
            } else if (line[0].equals("up")) {
                aim -= Integer.parseInt(line[1]);
            } 
        }
        System.out.println(d*h);
    }

    public static void part1(File file) {
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int h = 0, d = 0;
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" ");
            if (line[0].equals("forward")) {
                h += Integer.parseInt(line[1]);
            } else if (line[0].equals("down")) {
                d += Integer.parseInt(line[1]);
            } else if (line[0].equals("up")) {
                d -= Integer.parseInt(line[1]);
            } 
        }
        System.out.println(d*h);
    }
}
