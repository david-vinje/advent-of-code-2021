import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        File file = new File("Day1.txt");
        System.out.println(partOne(file));
        System.out.println(partTwo(file));
    }

    public static int partTwo(File file) {
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Integer> measurements = new ArrayList<>();
        while (scan.hasNextInt()) {
            measurements.add(scan.nextInt());
        }
        int prev = 0, count = 0;
        for (int i=0; i<3; i++) {
            prev += measurements.get(i);
        }
        for (int i=1; i<measurements.size()-2; i++) {
            int next = 0;
            for (int j=i; j<i+3; j++) {
                next += measurements.get(j);
            }
            if (next > prev)
                count++;
            prev = next;
        }
        scan.close();
        return count;
    }

    public static int partOne(File file) {
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int prev = scan.nextInt(), count = 0;
        while (scan.hasNextInt()) {
            int next = scan.nextInt();
            if (next > prev)
                count++;
            prev = next;
        }
        scan.close();
        return count;
    }
}