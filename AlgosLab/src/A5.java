import java.util.Arrays;
import java.util.Scanner;

public class A5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        char[] line = scanner.nextLine().toCharArray();
        int [] cells = new int[n];
        for (int i = 0; i < line.length; i++) {
            switch (line[i]) {
                case '"' -> cells[i] = 1;
                case '.' -> cells[i] = 0;
                case 'w' -> cells[i] = -1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (cells[i] == -1) {
                continue;
            }
            int max = -1;
            for (int j = 1; j < 4; j++) {
                if (i - (j * 2 - 1) >= 0) {
                    if (cells[i - (j * 2 - 1)] > max) {
                        max = cells[i - (j * 2 - 1)];
                    }
                }
            }
            if (max == -1) {
                cells[i] = -1;
            } else {
                cells[i] += max;
            }
        }
        System.out.println(cells[n - 1]);
    }
}
