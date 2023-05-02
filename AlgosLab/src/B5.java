import java.util.Arrays;
import java.util.Scanner;

public class B5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] board = new int[n][m];
        int[][][] way = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        long[][] dp = new long[n][m];
        dp[0][0] = board[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = board[i][j];
                } else {
                    dp[i][j] = Long.MIN_VALUE;
                    if (j > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + board[i][j]);
                        if (dp[i][j - 1] + board[i][j] >= dp[i][j]) {
                            way[i][j] = new int[]{i, j - 1};
                        }
                    }
                    if (i > 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + board[i][j]);
                        if (dp[i - 1][j] + board[i][j] >= dp[i][j]) {
                            way[i][j] = new int[]{i - 1, j};
                        }
                    }
                }
            }
        }
        char[] answer = new char[n + m - 2];
        int[] current = new int[]{n - 1, m -1};
        int i = 0;
        way[0][0] = new int[]{-1, -1};
        while (current[0] != 0 || current[1] != 0) {
            if (way[current[0]][current[1]][0] < current[0]) {
                answer[i] = 'D';
            } else {
                answer[i] = 'R';
            }
            current = way[current[0]][current[1]];
            i++;
        }
        System.out.println(dp[n - 1][m - 1]);
        for (int j = answer.length - 1; j >= 0 ; j--) {
            System.out.print(answer[j]);
        }
    }
}
