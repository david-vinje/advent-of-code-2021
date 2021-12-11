import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Day11 {
    private static final int width = 10;
    private static final int height = 10;
    private static final int lim = 9;
    private static  int flashCount = 0;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day11.txt");
        // part1(file);
        part2(file);
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int[][] grid = new int[height][width];
        for (int i=0; i<height; i++) {
            char[] line = scan.nextLine().toCharArray();
            for (int j=0; j<width; j++) {
                grid[i][j] = Character.getNumericValue(line[j]);
            }
        } 
        scan.close();
        for (int n=0; n<100; n++) {
            // First, the energy level of each octopus increases by 1.
            increaseGrid(grid);
            // Then, any octopus with an energy level greater than 9 flashes
            flashGrid(grid);
            // Finally, any octopus that flashed during this step has its energy level set to 0
            setGrid(grid);
        }
        System.out.println(flashCount);
    }

    public static void part2(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int[][] grid = new int[height][width];
        for (int i=0; i<height; i++) {
            char[] line = scan.nextLine().toCharArray();
            for (int j=0; j<width; j++) {
                grid[i][j] = Character.getNumericValue(line[j]);
            }
        } 
        scan.close();
        int stepCount = 0;
        boolean allFlashed = false;
        while (!allFlashed) {
            // First, the energy level of each octopus increases by 1.
            increaseGrid(grid);
            // Then, any octopus with an energy level greater than 9 flashes
            flashGrid(grid);
            // Finally, any octopus that flashed during this step has its energy level set to 0
            allFlashed = setGrid(grid);
            stepCount++;
            // if (stepCount == 195) {
            //     System.out.println("OMG IT'S HAPPENING!");
            // }
        }
        System.out.println(stepCount);
    }

    public static boolean setGrid(int[][] grid) {
        boolean allFlashed = true;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = grid[i][j] > lim ? 0 : grid[i][j];
                if (grid[i][j] != 0) {
                    allFlashed = false;
                }
            }
        }
        return allFlashed;
    }

    public static void flashGrid(int[][] grid) {
        boolean[][] hasFlashed = new boolean[height][width];
        boolean flashHappened;
        do {
            flashHappened = false;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grid[i][j] > lim && !hasFlashed[i][j]) {
                        flash(grid, i, j);
                        flashHappened = true;
                        hasFlashed[i][j] = flashHappened;
                    }
                }
            }
        } while(flashHappened);
    }

    public static void flash(int[][] grid, int i, int j) {
        flashCount++;
        // Look north
        if (i>0) {
            grid[i-1][j]++;
        } 
        // Look south
        if (i<height-1) {
            grid[i+1][j]++;
        }
        // Look east
        if (j<width-1) {
            grid[i][j+1]++;
        }
        // Look west
        if (j>0) {
            grid[i][j-1]++;
        }
        // Look north.west
        if (i>0 && j>0) {
            grid[i-1][j-1]++;
        }
        // Look north.east
        if (i>0 && j<width-1) {
            grid[i-1][j+1]++;
        }
        // Look south.west
        if (i<height-1 && j>0) {
            grid[i+1][j-1]++;
        }
        // Look south.east
        if (i<height-1 && j<width-1) {
            grid[i+1][j+1]++;
        }
    }  

    public static void increaseGrid(int[][] grid) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j]++;
            }
        }
    }
}
