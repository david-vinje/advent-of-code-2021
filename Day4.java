import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Day4 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day4.txt");
        part1(file);
        part2(file);
    }

    static void part2(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        Map<int[][], Boolean[][]> boards = new HashMap<>();
        String[] draws = scan.nextLine().split(",");
        while (scan.hasNextLine()) {
            int[][] nums = new int[5][5];
            Boolean[][] vals = new Boolean[5][5];
            for (int i=0; i<5; i++) {
                for (int j=0; j<5; j++) {
                    nums[i][j] = scan.nextInt();
                    vals[i][j] = false;
                }
            }
            boards.put(nums, vals);
        }
        scan.close();
        int lastDraw = 0;
        Map<int[][], Boolean[][]> lastBoard = new HashMap<>(boards);
        for (int i=0; i<draws.length; i++) {
            int draw = Integer.parseInt(draws[i]);
            lastDraw = draw;
            for (var board : boards.entrySet()) {
                var nums = board.getKey();
                Boolean[][] vals = board.getValue();
                for (int j=0; j<5; j++) {
                    for (int k=0; k<5; k++) {
                        if (nums[j][k] == draw) {
                            vals[j][k] = true;
                            boards.put(nums, vals);
                            boolean bingo = checkBoard2(board, nums[j][k]);
                            if (bingo) {
                                lastBoard.remove(nums);
                                if (lastBoard.isEmpty()) {
                                    finish(board, lastDraw);
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    static boolean checkBoard2(Entry<int[][], Boolean[][]> board, int n) {
        boolean bingo = true;
        var vals = board.getValue();
        for (int i=0; i<5; i++) {
            bingo = true;
            for (int j=0; j<5; j++) {
                if (Boolean.FALSE.equals(vals[i][j]))
                    bingo = false;
            }
            if (bingo) return true;
        }
        for (int i=0; i<5; i++) {
            bingo = true;
            for (int j=0; j<5; j++) {
                if (Boolean.FALSE.equals(vals[j][i]))
                    bingo = false;
            }
            if (bingo) return true;
        }
        return false;
    }

    static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        Map<int[][], Boolean[][]> boards = new HashMap<>();
        String[] draws = scan.nextLine().split(",");
        while (scan.hasNextLine()) {
            int[][] nums = new int[5][5];
            Boolean[][] vals = new Boolean[5][5];
            for (int i=0; i<5; i++) {
                for (int j=0; j<5; j++) {
                    nums[i][j] = scan.nextInt();
                    vals[i][j] = false;
                }
            }
            boards.put(nums, vals);
        }
        scan.close();
        for (int i=0; i<draws.length; i++) {
            int draw = Integer.parseInt(draws[i]);
            for (var board : boards.entrySet()) {
                var nums = board.getKey();
                Boolean[][] vals = board.getValue();
                for (int j=0; j<5; j++) {
                    for (int k=0; k<5; k++) {
                        if (nums[j][k] == draw) {
                            vals[j][k] = true;
                            boards.put(nums, vals);
                            checkBoard1(board, nums[j][k]);
                        }
                    }
                }
            }
        }
    }

    // 7 4 9 5 11
    // 17 23 2 0 14 21
    // 24: WINNER!

    static void checkBoard1(Entry<int[][], Boolean[][]> board, int n) {
        boolean bingo = true;
        var vals = board.getValue();
        for (int i=0; i<5; i++) {
            bingo = true;
            for (int j=0; j<5; j++) {
                if (Boolean.FALSE.equals(vals[i][j]))
                    bingo = false;
            }
            if (bingo) finish(board, n);
        }
        for (int i=0; i<5; i++) {
            bingo = true;
            for (int j=0; j<5; j++) {
                if (Boolean.FALSE.equals(vals[j][i]))
                    bingo = false;
            }
            if (bingo) finish(board, n);
        }
    }

    static void finish(Entry<int[][], Boolean[][]> board, int n) {
        int sum = 0;
        var nums = board.getKey();
        var vals = board.getValue();
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (Boolean.FALSE.equals(vals[i][j])) {
                    sum += nums[i][j];
                }
            }
        }
        // Part 1: 188 * 24 = 4512
        // Part 2: 148 * 13 = 1924
        System.out.format("%d*%d = %d\n", sum, n, n*sum);
    }
}
