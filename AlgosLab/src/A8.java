import java.util.Arrays;
import java.util.Scanner;

public class A8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = scanner.nextInt();
        }
        boolean[][] dp = new boolean [n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - source[i - 1] >= 0) {
                    if (dp[i - 1][j - source[i - 1]]) {
                        dp[i][j] = dp[i - 1][j - source[i - 1]];
                    }
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                System.out.println(i);
                break;
            }
        }

    }
}
