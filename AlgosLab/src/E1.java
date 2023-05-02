import java.util.Arrays;
import java.util.Scanner;

public class E1 {
    public static long counter = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextInt();
        int[] source = new int[n];
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = scanner.nextInt();
            if (i > 0) {
                prefix[i] = source[i] + prefix[i - 1];
            } else {
                prefix[i] = source[i];
            }
        }
        System.out.println(Arrays.toString(prefix));
        sort(prefix, k);
        System.out.println(Arrays.toString(prefix));
        System.out.println(counter);
    }

    public static int[] merge(int[] firstArray, int[] secondArray, long k) {
        int n = firstArray.length;
        int m = secondArray.length;
        int[] c = new int[n + m];
        int i = 0, j = 0;
        while (i < n || j < m) {
            if (j == m) {
                c[i + j] = firstArray[i];
                i++;
            } else if (i == n) {
                c[i + j] = secondArray[j];
                j++;
            } else if (firstArray[i] <= secondArray[j]) {
                c[i + j] = firstArray[i];
                i++;
            } else {
                c[i + j] = secondArray[j];
                j++;
            }
        }
        return c;
    }

    public static int[] sort(int[] array, long k) {
        int n = array.length;
        if (n <= 1) {
            return (array);
        } else {
            int[] a1 = Arrays.copyOfRange(array, 0, n / 2);
            int[] a2 = Arrays.copyOfRange(array, n / 2, n);
            return merge(sort(a1, k), sort(a2, k), k);
        }
    }
}
