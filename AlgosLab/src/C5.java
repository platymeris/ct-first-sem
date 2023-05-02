import java.util.Arrays;
import java.util.Scanner;

public class C5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        int[] way = new int[n];
        dp[0] = 1;
        int straight = -1;
        int index = -1;
        for (int i = 0; i < n; i++) {
            int max = 1;
            way[i] = i;
            for (int j = 0; j < i; j++) {
                if (source[j] < source[i]) {
                    if (dp[j] >= max) {
                        max = dp[j] + 1;
                        way[i] = j;
                    }
                }
            }
            if (max > straight) {
                straight = max;
                index = i;
            }
            dp[i] = max;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int[] answer = new int[dp[index]];
        System.out.println(dp[index]);
        int i = 0;
        while (way[index] != index) {
            answer[i] = source[index];
            index = way[index];
            i++;
        }
        answer[i] = source[index];
        for (int j = answer.length - 1; j >= 0; j--) {
            stringBuilder.append(answer[j]).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
