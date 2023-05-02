import java.util.Arrays;
import java.util.Scanner;

public class F3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] source = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            source[i] = scanner.nextInt();
            if (source[i] > max) {
                max = source[i];
            }
        }
        int left = 0;
        int right = max;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (checkAnswer(source, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (checkAnswer(source, k, right)) {
            System.out.println(right);
        } else if (checkAnswer(source, k, left)){
            System.out.println(left);
        } else {
            System.out.println(0);
        }
    }
    public static boolean checkAnswer(int[] source, int k, int mid) {
        int[] array = Arrays.copyOf(source, source.length);
        int moneyCounter = 0;
        for (int i = 0; i < array.length; i++) {
            while (array[i] >= mid) {
                array[i] -= mid;
                moneyCounter++;
                if (moneyCounter >= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
