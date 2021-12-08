import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day8 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day8.txt");
        // part1(file);
        part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int count = 0;
        while (scan.hasNextLine()) {
            String line[] = scan.nextLine().split(" \\| ");
            for (String s : line[1].split(" ")) {
                if (s.length() == 4 || s.length() == 3 || s.length() == 7 || s.length() == 2)
                    count++;
            }
        }
        System.out.println(count);
    }

    public static void part2(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        // List<String> input = new ArrayList<>();
        // List<String> digits = new ArrayList<>();
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" \\| ");
            // input.add(line[0]);
            // digits.add(line[1]);
            String input = line[0];
            String digits = line[1];
            Map<Integer, String> map = new HashMap<>();
            List<String> twoOrThreeOrFive = new ArrayList<>();
            List<String> sixOrNineOrZero = new ArrayList<>();
            for (String s : input.split(" ")) {
                for (String ss : s.split(" ")) {
                    switch (ss.length()) {
                        case 2:
                            char[] ch = ss.toCharArray();
                            Arrays.sort(ch);
                            ss = new String(ch); 
                            map.put(1, ss);
                            break;
                        case 3:
                            ch = ss.toCharArray();
                            Arrays.sort(ch);
                            ss = new String(ch); 
                            map.put(7, ss);
                            break;
                        case 4:
                            ch = ss.toCharArray();
                            Arrays.sort(ch);
                            ss = new String(ch); 
                            map.put(4, ss);
                            break;
                        case 5: 
                            ch = ss.toCharArray();
                            Arrays.sort(ch);
                            ss = new String(ch);   
                            twoOrThreeOrFive.add(ss);
                            break;
                        case 6:
                            ch = ss.toCharArray();
                            Arrays.sort(ch);
                            ss = new String(ch); 
                            sixOrNineOrZero.add(ss);
                            break;
                        default:
                            ch = ss.toCharArray();
                            Arrays.sort(ch);
                            ss = new String(ch); 
                            map.put(8, ss);
                    }
                }
            }
            // find 2 using 4
            for (String s : twoOrThreeOrFive) {
                if (findDifference(s, map.get(4)) == 3) {
                    char[] ch = s.toCharArray();
                    Arrays.sort(ch);
                    s = new String(ch); 
                    map.put(2, s);
                    twoOrThreeOrFive.remove(s);
                    break;
                }
            }
            // find 3 and 5 using 2
            for (String s : twoOrThreeOrFive) {
                if (findDifference(s, map.get(2)) == 1) {
                    char[] ch = s.toCharArray();
                    Arrays.sort(ch);
                    s = new String(ch); 
                    map.put(3, s);
                } else if (findDifference(s, map.get(2)) == 2) {
                    char[] ch = s.toCharArray();
                    Arrays.sort(ch);
                    s = new String(ch); 
                    map.put(5, s);
                }
            }
            // find 9 using 3
            for (String s : sixOrNineOrZero) {
                if (findDifference(s, map.get(3)) == 1) {
                    map.put(9, s);
                    char[] ch = s.toCharArray();
                    Arrays.sort(ch);
                    s = new String(ch); 
                    sixOrNineOrZero.remove(s);
                    break;
                } 
            }
            // find zero and 6 using 7
            for (String s : sixOrNineOrZero) {
                if (findDifference(s, map.get(7)) == 3) {
                    char[] ch = s.toCharArray();
                    Arrays.sort(ch);
                    s = new String(ch); 
                    map.put(0, s);
                } else if (findDifference(s, map.get(7)) == 4) {
                    char[] ch = s.toCharArray();
                    Arrays.sort(ch);
                    s = new String(ch); 
                    map.put(6, s);
                }
            }
            for (String digit : digits.split(" ")) {
                
            }
        }
    }

    public static int findDifference(String s1, String s2) {
        String s = "";
        for (char c1 : s1.toCharArray()) {
            boolean isContained = false;
            for (char c2 : s2.toCharArray()) {
                if (c2 == c1)
                    isContained = true;
            }
            if (!isContained)
                s += "" + c1;
        }
        return s.length();
    }

    // public static void part2(File file) throws FileNotFoundException {
    //     Scanner scan = new Scanner(file);
    //     List<String> input = new ArrayList<>();
    //     List<String> digits = new ArrayList<>();
    //     while (scan.hasNextLine()) {
    //         String[] line = scan.nextLine().split(" \\| ");
    //         input.add(line[0]);
    //         digits.add(line[1]);
    //     }
    //     Map<Integer, String> map = new HashMap<>();
    //     Map<Integer, String> oneSevenFourEight = new HashMap<>();
    //     List<String> twoOrThreeOrFive = new ArrayList<>();
    //     List<String> sixOrNineOrZero = new ArrayList<>();

    //     for (String s : input) {
    //         for (String ss : s.split(" ")) {
    //             switch (ss.length()) {
    //                 case 2:
    //                     oneSevenFourEight.put(1, ss);
    //                     break;
    //                 case 3:
    //                     oneSevenFourEight.put(7, ss);
    //                     break;
    //                 case 4:
    //                     oneSevenFourEight.put(4, ss);
    //                     break;
    //                 case 5: 
    //                     twoOrThreeOrFive.add(ss);
    //                     break;
    //                 case 6:
    //                     sixOrNineOrZero.add(ss);
    //                     break;
    //                 default:
    //                     oneSevenFourEight.put(8, ss);
    //             }
    //         }
    //     }
    //     map.put(1, findDifference(oneSevenFourEight.get(7), oneSevenFourEight.get(1)));
    //     map.put(3, findSimilarity(oneSevenFourEight.get(7), oneSevenFourEight.get(1)));
    //     map.put(6, findSimilarity(oneSevenFourEight.get(7), oneSevenFourEight.get(1)));
    //     map.put(2, findDifference(oneSevenFourEight.get(4), oneSevenFourEight.get(1)));
    //     map.put(4, findDifference(oneSevenFourEight.get(4), oneSevenFourEight.get(1)));
    //     String fiveAndSix = "";
    //     for (String s : twoOrThreeOrFive) {
    //         String diff = 
    //     }
    // }

    // public static String findSimilarity(String s1, String s2) {
    //     String s = "";
    //     for (char c1 : s1.toCharArray()) {
    //         boolean isContained = false;
    //         for (char c2 : s2.toCharArray()) {
    //             if (c2 == c1)
    //                 isContained = true;
    //         }
    //         if (isContained)
    //             s += "" + c1;
    //     }
    //     return s;
    // }

    // public static String findDifference(String s1, String s2) {
    //     String s = "", longString = "", shortString = "";
    //     if (s1.length() > s2.length()) {
    //         longString = s1;
    //         shortString = s2;
    //     } else {
    //         longString = s2;
    //         shortString = s1;
    //     }
    //     for (char c1 : longString.toCharArray()) {
    //         boolean isContained = false;
    //         for (char c2 : shortString.toCharArray()) {
    //             if (c2 == c1)
    //                 isContained = true;
    //         }
    //         if (!isContained)
    //             s += "" + c1;
    //     }
    //     return s;
    // }
}