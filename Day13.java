import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day13 {
    static int height = 0, width = 0;
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day13.txt");
        // part1(file);
        part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<int[]> pos = new ArrayList<>();
        String line = scan.nextLine();
        while (!line.equals("")) {
            String[] nums = line.split(",");
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            width = Math.max(width, x+1);
            height = Math.max(height, y+1);
            pos.add(new int[]{x, y});
            line = scan.nextLine();
        }
        char[][] paper = new char[height][width];
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                paper[i][j] = '.';
            }
        }
        for (int[] xy : pos) {
            paper[xy[1]][xy[0]] = '#';
        }
        String folding = scan.nextLine().replace("fold along ", "");
        String direction = folding.substring(0, 1);
        int num = Integer.parseInt(folding.substring(2));
        if (direction.equals("x")) {
            paper = foldPaperVertically(paper, num);
        } else {
            paper = foldPaperHorizontally(paper, num);
        }
        System.out.println(countDots(paper));
    }

    public static void part2(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<int[]> pos = new ArrayList<>();
        String line = scan.nextLine();
        while (!line.equals("")) {
            String[] nums = line.split(",");
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            width = Math.max(width, x+1);
            height = Math.max(height, y+1);
            pos.add(new int[]{x, y});
            line = scan.nextLine();
        }
        List<String> foldings = new ArrayList<>();
        while (scan.hasNextLine()) {
            line = scan.nextLine().replace("fold along ", "");
            foldings.add(line);
        }
        char[][] paper = new char[height][width];
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                paper[i][j] = '.';
            }
        }
        for (int[] xy : pos) {
            paper[xy[1]][xy[0]] = '#';
        }
        for (String folding : foldings) {
            String direction = folding.substring(0, 1);
            int num = Integer.parseInt(folding.substring(2));
            if (direction.equals("x")) {
                paper = foldPaperVertically(paper, num);
            } else {
                paper = foldPaperHorizontally(paper, num);
            }
        }
        print(paper);
        System.out.println(countDots(paper));
    }

    public static int countDots(char[][] paper) {
        int count = 0;
        for (int i=0; i<paper.length; i++) {
            for (int j=0; j<paper[0].length; j++) {
                count = paper[i][j] == '.' ? count : count+1;
            }
        }
        return count;
    }

    public static char[][] foldPaperVertically(char[][] paper, int num) {
        char[][] newPaper = new char[height][num];
        for (int i=0; i<height; i++) {
            for (int j=0; j<num; j++) {
                newPaper[i][j] = paper[i][j] == '#' || paper[i][width-1-j] == '#' ? '#' : '.';
            }
        }
        width = num;
        return newPaper;
    }

    public static char[][] foldPaperHorizontally(char[][] paper, int num) {
        char[][] newPaper = new char[num][width];
        for (int i=0; i<num; i++) {
            for (int j=0; j<width; j++) {
                newPaper[i][j] = paper[i][j] == '#' || paper[height-1-i][j] == '#' ? '#' : '.';
            }
        }
        height = num;
        return newPaper;
    }

    public static void print(char[][] paper) {
        for (int i=0; i<paper.length; i++) {
            for (int j=0; j<paper[0].length; j++) {
                System.out.print(paper[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}