import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day6 {
    private static int days = 256;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day6.txt");
        // part1(file);
        part2(file);
    }

    public static void part2(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        Map<Integer, Long> list = new HashMap<>();
        String[] line = scan.nextLine().split(",");
        scan.close();
        for (String l : line) {
            int timer = Integer.parseInt(l);
            if (list.containsKey(timer)) {
                list.put(timer, list.get(timer)+1);
            } else {
                list.put(timer, (long) 1);
            }
        }
        for (long j=0; j<days; j++) {
            long count = 0;
            Map<Integer, Long> newList = new HashMap<>();
            for (Entry<Integer, Long> entry : list.entrySet()) {
                int timer = entry.getKey();
                long num = entry.getValue();
                if (timer == 0) {
                    if (newList.containsKey(6)) {
                        newList.put(6, newList.get(6)+num);
                    } else {
                        newList.put(6, num);
                    }
                    count += num;
                    continue;
                } 
                if (newList.containsKey(timer-1)) {
                    newList.put(timer-1, newList.get(timer-1)+num);
                } else {
                    newList.put(timer-1, num);
                }
            }
            if (count > 0) 
                newList.put(8, count);
            list = new HashMap<>(newList);
        }
        System.out.println(mapCount(list));
    }

    public static String mapCount(Map<Integer, Long> list) {
        BigInteger count = new BigInteger("0");
        for (long val : list.values()) {
            count = count.add(BigInteger.valueOf(val));
        }
        return count.toString();
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        String[] line = scan.nextLine().split(",");
        scan.close();
        for (String l : line) {
            list.add(Integer.parseInt(l));
        }
        for (int j=0; j<days; j++) {
            int count = 0;
            for (int i=0; i<list.size(); i++) {
                int num = list.get(i);
                if (num == 0) {
                    list.set(i, 6);
                    count++;
                } else {
                    list.set(i, num-1);
                }
            }
            for (int i=0; i<count; i++)
                list.add(8);
        }
        System.out.println(list.size());
    }
}