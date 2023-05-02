import java.util.Arrays;
import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        boolean flag = true;
        int[][] comparators = new int[k][];
        for (int i = 0; i < k; i++) {
            comparators[i] = new int[scanner.nextInt() * 2];
            for (int j = 0; j < comparators[i].length; j += 2) {
                comparators[i][j] = scanner.nextInt();
                comparators[i][j + 1] = scanner.nextInt();
                if (comparators[i][j + 1] < comparators[i][j]) {
                    int temp =  comparators[i][j];
                    comparators[i][j] =  comparators[i][j + 1];
                    comparators[i][j + 1] = temp;
                }
            }
        }
        scanner.close();
        outer: for (char[] i : binArray(n)) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < comparators[j].length; l += 2) {
                    int first = comparators[j][l] - 1;
                    int second = comparators[j][l + 1] - 1;
                    if (i[first] > i[second]) {
                        swap(i, first, second);
                    }
                }
            }
            for (int j = 1; j < i.length; j++) {
                if (i[j] < i[j - 1]) {
                    flag = false;
                    break outer;
                }
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
    public static void swap(char[] source, int x, int y)  {
        char temp = source[x];
        source[x] = source[y];
        source[y] = temp;
    }
    static char[][] binArray(int n) {
        char[][] result = new char[(int) Math.pow(2, n)][n];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.toBinaryString(i).toCharArray();
            if (result[i].length != n) {
                char[] temp = new char[n];
                Arrays.fill(temp, '0');
                System.arraycopy(result[i], 0, temp, n - result[i].length, result[i].length);
                result[i] = temp;
            }
        }
        return result;
    }
}
