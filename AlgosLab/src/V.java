import java.util.Arrays;
import java.util.Scanner;

public class V {

    int quantity = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = scanner.nextInt();
        }
    }

    public static int[] merge(int[] firstArray, int[] secondArray) {
        int n = firstArray.length;
        int m = secondArray.length;
        int[] c = new int[n+m];
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
    public static int[] sort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return(array);
        } else {
            int[] a1 = Arrays.copyOfRange(array, 0, n/2);
            int[] a2 = Arrays.copyOfRange(array, n/2, n);
            return merge(sort(a1), sort(a2));
        }
    }
}

