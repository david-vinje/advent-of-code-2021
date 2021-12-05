import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Day5 {
    private static int n = 1000;

    public static void main(String[] args) throws IOException {
        File file = new File("day5.txt");
        System.out.println(part1(file));
        System.out.println(part2(file));
    }

    static int part2(File file) throws IOException {
        Scanner scan = new Scanner(file);
        char[][] diagram = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                diagram[i][j] = '.';
            }
        }
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" -> ");
            String[] xy1 = line[0].split(",");
            String[] xy2 = line[1].split(",");
            int x1 = Integer.parseInt(xy1[0]);
            int y1 = Integer.parseInt(xy1[1]);
            int x2 = Integer.parseInt(xy2[0]);
            int y2 = Integer.parseInt(xy2[1]);
            int xd = Math.abs(x2-x1);
            int yd = Math.abs(y2-y1);
            int xsign = x1 > x2 ? -1 : 1;
            int ysign = y1 > y2 ? -1 : 1;
            if (xd > 0 && yd > 0) {
                for (int i=0; i<=xd; i++) {
                    char d = diagram[y1+i*ysign][x1+i*xsign];
                    if (d == '.') {
                        diagram[y1+i*ysign][x1+i*xsign] = '1';
                    } else {
                        int x = Character.getNumericValue(d)+1;
                        diagram[y1+i*ysign][x1+i*xsign] = (char)(x+'0');
                    }
                }
            } else if (xd > 0) {
                for (int i=0; i<=xd; i++) {
                    char d = diagram[y1][x1+i*xsign];
                    if (d == '.') {
                        diagram[y1][x1+i*xsign] = '1';
                    } else {
                        int x = Character.getNumericValue(d)+1;
                        diagram[y1][x1+i*xsign] = (char)(x+'0');
                    }
                }
            } else if (yd > 0) {
                for (int i=0; i<=yd; i++) {
                    char d = diagram[y1+i*ysign][x1];
                    if (d == '.') {
                        diagram[y1+i*ysign][x1] = '1';
                    } else {
                        int x = Character.getNumericValue(d)+1;
                        diagram[y1+i*ysign][x1] = (char)(x+'0');
                    }
                }
            }
        }
        scan.close();
        // StringBuilder sb = new StringBuilder(); 
        // String formatter = "";
        int count = 0;
        for (int i=0; i<n; i++) {
            // sb.append(formatter);
            for (int j=0; j<n; j++) {
                char d = diagram[i][j];
                // formatter = "\n";
                // sb.append(d);
                if (d != '.' && Character.getNumericValue(d) > 1)
                    count++;
            }
        }
        // System.out.println(sb.toString());
        return count;
    }

    static int part1(File file) throws IOException {
        Scanner scan = new Scanner(file);
        char[][] diagram = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                diagram[i][j] = '.';
            }
        }
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" -> ");
            String[] xy1 = line[0].split(",");
            String[] xy2 = line[1].split(",");
            int x1 = Integer.parseInt(xy1[0]);
            int y1 = Integer.parseInt(xy1[1]);
            int x2 = Integer.parseInt(xy2[0]);
            int y2 = Integer.parseInt(xy2[1]);
            if (x1 != x2 && y1 != y2) {
                continue;
            }
            if (x1 != x2) {
                int sign = x1 > x2 ? -1 : 1;
                int xd = Math.abs(x2-x1);
                for (int i=0; i<=xd; i++) {
                    char d = diagram[y1][x1+i*sign];
                    if (d == '.') {
                        diagram[y1][x1+i*sign] = '1';
                    } else {
                        int x = Character.getNumericValue(d)+1;
                        diagram[y1][x1+i*sign] = (char)(x+'0');
                    }
                }
            } else {
                int sign = y1 > y2 ? -1 : 1;
                int yd = Math.abs(y2-y1);
                for (int i=0; i<=yd; i++) {
                    char d = diagram[y1+i*sign][x1];
                    if (d == '.') {
                        diagram[y1+i*sign][x1] = '1';
                    } else {
                        int x = Character.getNumericValue(d)+1;
                        diagram[y1+i*sign][x1] = (char)(x+'0');
                    }
                }
            }
        }
        scan.close();
        // StringBuilder sb = new StringBuilder(); 
        // String formatter = "";
        int count = 0;
        for (int i=0; i<n; i++) {
            // sb.append(formatter);
            for (int j=0; j<n; j++) {
                char d = diagram[i][j];
                // formatter = "\n";
                // sb.append(d);
                if (d != '.' && Character.getNumericValue(d) > 1)
                    count++;
            }
        }
        // System.out.println(sb.toString());
        return count;
    }
}