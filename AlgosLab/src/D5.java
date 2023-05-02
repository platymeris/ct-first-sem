import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class D5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] first = new int[n];
        for (int i = 0; i < n; i++) {
            first[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] second = new int[m];
        for (int i = 0; i < m; i++) {
            second[i] = scanner.nextInt();
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int i = n;
        int j = m;
        List<Integer> answer = new ArrayList<>();
        while (dp[i][j] != 0) {
            if (first[i - 1] == second[j - 1]) {
                answer.add(first[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                answer.add(second[j - 1]);
                i--;
            } else {
                answer.add(second[i - 1]);
                j--;
            }
        }
        System.out.println(dp[n][m]);
        System.out.println(Arrays.toString(answer.toArray()));
    }
}
