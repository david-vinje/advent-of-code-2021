import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day13 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day13.txt");
        part1(file);
        // part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int width = 0, height = 0;
        // List<Integer> xs = new ArrayList<>();
        // List<Integer> ys = new ArrayList<>();
        List<int[]> pos = new ArrayList<>();
        String line = scan.nextLine();
        while (!line.equals("")) {
            String[] nums = line.split(",");
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            width = Math.max(width, x+1);
            height = Math.max(height, y+1);
            // xs.add(x);
            // ys.add(y);
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
                paper = foldPaperVertically(paper);
            } else {
                paper = foldPaperHorizontally(paper);
            }
        }
    }

    public static char[][] foldPaperVertically(char[][] paper) {

        return null;
    }

    public static char[][] foldPaperHorizontally(char[][] paper) {
        
        return null;
    }
}