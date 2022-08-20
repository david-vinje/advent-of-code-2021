import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day12 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day12.txt");
        // part1(file);
        part2(file);
    }

    public static void part2(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<String> lines = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split("-");
            if (split[0].equals("start")) {
                paths.add(line);
                continue;
            }
            if (split[1].equals("end")) {
                lines.add(line);
                continue;
            }
            if (split[1].equals("start")) {
                line = split[1] + "-" + split[0];
                paths.add(line);
                continue;
            }
            if (split[0].equals("end")) {
                line = split[1] + "-" + split[0];
                lines.add(line);
                continue;
            }
            lines.add(line);
            line = split[1] + "-" + split[0];
            lines.add(line);
        }
        scan.close();
        boolean changed;
        do {
            List<String> tmp = new ArrayList<>(paths);
            changed = false;
            for (String l1 : paths) {
                String[] s1 = l1.split("-");
                for (String l2 : lines) {
                    if (l1.equals(l2)) {
                        continue;
                    }
                    String[] s2 = l2.split("-");
                    if (s1[0].equals("start") && s2[0].equals("start")) {
                        continue;
                    }
                    if (s1[s1.length - 1].equals(s2[0])) {
                        String start = l1.substring(0, l1.length()-s1[s1.length-1].length());
                        String newPath = start + l2;
                        if (checkPath2(newPath) && !paths.contains(newPath)) {
                            tmp.add(newPath);
                            if (tmp.size() % 10000 == 0) {
                                System.out.println(tmp.size());
                            }
                            changed = true;
                        }
                    }
                }
            }
            paths = tmp;
        } while (changed);
        paths = cleanList(paths);
        System.out.println(paths.size());
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<String> lines = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] split = line.split("-");
            if (split[0].equals("start")) {
                lines.add(line);
                paths.add(line);
                continue;
            }
            if (split[1].equals("end")) {
                lines.add(line);
                continue;
            }
            if (split[1].equals("start")) {
                line = split[1] + "-" + split[0];
                lines.add(line);
                paths.add(line);
                continue;
            }
            if (split[0].equals("end")) {
                line = split[1] + "-" + split[0];
                lines.add(line);
                continue;
            }
            lines.add(line);
            line = split[1] + "-" + split[0];
            lines.add(line);
        }
        scan.close();
        boolean changed;
        do {
            List<String> tmp = new ArrayList<>(paths);
            changed = false;
            for (String l1 : paths) {
                String[] s1 = l1.split("-");
                for (String l2 : lines) {
                    if (l1.equals(l2)) {
                        continue;
                    }
                    String[] s2 = l2.split("-");
                    if (s1[0].equals("start") && s2[0].equals("start")) {
                        continue;
                    }
                    if (s1[s1.length - 1].equals(s2[0])) {
                        String start = l1.substring(0, l1.length()-s1[s1.length-1].length());
                        String newPath = start + l2;
                        if (checkPath1(newPath) && !paths.contains(newPath)) {
                            tmp.add(newPath);
                            changed = true;
                        }
                    }
                }
            }
            paths = tmp;
        } while (changed);
        paths = cleanList(paths);
        System.out.println(paths.size());
    }

    public static List<String> cleanList(List<String> lines) {
        List<String> tmp = new ArrayList<>(lines);
        for (String path : lines) {
            String[] split = path.split("-");
            if (!(split[0].equals("start") && split[split.length - 1].equals("end"))) {
                tmp.remove(path);
            }
        }
        return tmp;
    }

    public static boolean checkPath1(String path) {
        String[] split = path.split("-");
        for (String p : split) {
            if (p.equals(p.toLowerCase())) {
                List<String> list = new ArrayList<>();
                Collections.addAll(list, split);
                list.remove(p);
                if (list.contains(p)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkPath2(String path) {
        List<String> list = new ArrayList<>();
        boolean firstFound = false;
        String[] split = path.split("-");
        Collections.addAll(list, split);
        for (String p : split) {
            if (p.equals(p.toLowerCase())) {
                list.remove(p);
                if (list.contains(p) && firstFound) {
                    return false;
                } else if (list.contains(p)) {
                    list.remove(p);
                    if (list.contains(p)) {
                        return false;
                    }
                    firstFound = true;
                }
            }
        }
        return true;
    }
}
