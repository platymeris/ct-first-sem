import java.util.Arrays;
import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long p = scanner.nextLong();
        long[] source = new long[n];
        sort(source);
        for (int i = 0; i < n; i++) {
            source[i] = scanner.nextLong();
        }
        source = sort(source);
        long result = 0;
        int usedBarrelsQuantity = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (source[i] < p) {
                break;
            }
            while (source[i] >= p) {
                if (usedBarrelsQuantity < m) {
                    result += p;
                    usedBarrelsQuantity++;
                    source[i] -= p;
                } else {
                    break;
                }
            }
        }
        source = sort(source);
        for (int i = n - 1; i >= 0; i--) {
            if (usedBarrelsQuantity < m) {
                result += source[i];
                usedBarrelsQuantity++;
            } else {
                break;
            }
        }
        System.out.println(result);
    }

    public static long[] merge(long[] firstArray, long[] secondArray) {
        int n = firstArray.length;
        int m = secondArray.length;
        long[] c = new long[n+m];
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
    public static long[] sort(long[] array) {
        int n = array.length;
        if (n <= 1) {
            return(array);
        } else {
            long[] a1 = Arrays.copyOfRange(array, 0, n/2);
            long[] a2 = Arrays.copyOfRange(array, n/2, n);
            return merge(sort(a1), sort(a2));
        }
    }
}
