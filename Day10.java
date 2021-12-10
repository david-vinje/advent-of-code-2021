import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Day10 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("day10.txt");
        // part1(file);
        part2(file);
    }

    public static void part2(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        List<Long> scores = new ArrayList<>();
        while (scan.hasNextLine()) {
            Deque<Character> deque = new ArrayDeque<>();
            String line = scan.nextLine();
            char[] ch = line.toCharArray();
            boolean bueno = true;
            for (char c : ch) {
                if (c == '{' || c == '[' || c == '(' || c == '<')
                    deque.push(c);
                else {
                    char illegal = deque.pop();
                    if ((c == ']' && illegal != '[')
                            || (c == '>' && illegal != '<')
                            || (c == ')' && illegal != '(')
                            || (c == '}' && illegal != '{')) {
                        bueno = false;
                        break;
                    }
                }
            }
            if (!bueno) continue;
            long score = 0;
            while (!deque.isEmpty()) {
                score *= 5;
                char legal = deque.pop();
                if (legal == '(') {
                    score += 1;
                } else if (legal == '[') {
                    score += 2;
                } else if (legal == '{') {
                    score += 3;
                } else if (legal == '<') {
                    score += 4;
                }
            }
            scores.add(score);
        }
        Collections.sort(scores);
        System.out.println(scores.get(scores.size() / 2));
    }

    public static void part1(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int points = 0;
        char illegal = '0';
        while (scan.hasNextLine()) {
            Deque<Character> deque = new ArrayDeque<>();
            String line = scan.nextLine();
            char[] ch = line.toCharArray();
            for (char c : ch) {
                if (c == '{' || c == '[' || c == '(' || c == '<')
                    deque.push(c);
                else {
                    illegal = deque.pop();
                    if (c == ']' && illegal != '[') {
                        points += 57;
                        break;
                    } else if (c == '>' && illegal != '<') {
                        points += 25137;
                        break;
                    } else if (c == ')' && illegal != '(') {
                        points += 3;
                        break;
                    } else if (c == '}' && illegal != '{') {
                        points += 1197;
                        break;
                    }
                }
            }
        }
        System.out.println(points);
    }
}
