import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] source = new long[n];
        for (int i = 0; i < n; i++) {
            source[i] = i + 1;
        }
        antiQsort(source);
        for (long l: source) {
            System.out.print(l + " ");
        }
    }
    public static void swap(long[] source, int x, int y)  {
        long temp = source[x];
        source[x] = source[y];
        source[y] = temp;

    }

    public static void antiQsort(long[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            swap(a, i, i / 2);
        }
    }
    public static long[] partition(long[] array, int l, int r) {
        long v = array[(l + r) / 2];
        int i = l;
        int j = r - 1;
        while (i <= j) {
            while (array[i] < v) {
                i++;
            }
            while (array[j] > v) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(array, i++, j--);
        }
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = j;
        return array;
    }
}