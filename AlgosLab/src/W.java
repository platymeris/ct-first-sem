import java.util.Scanner;

public class W {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = scanner.nextInt();
        }
        int[] keys = new int[k];
        for (int i = 0; i < k; i++) {
            keys[i] = scanner.nextInt();
        }

        for (int i : keys) {
            System.out.print(binSearchLeft(source, i) + " ");
            if (binSearchLeft(source, i) != 0) {
                System.out.println(binSearchRight(source, i));
            }
        }
    }

    public static int binSearchLeft(int[] source, int key) {
        int left = -1;
        int right = source.length;
        while (right > left + 1) {
            int mid = (left + right) / 2;
            if (source[mid] >= key) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (left > -1 && source[left] == key) {
            return left + 1;
        }
        if (right < source.length && source[right] == key) {
            return right + 1;
        }
        return 0;
    }
    public static int binSearchRight(int[] source, int key) {
        int left = -1;
        int right = source.length;
        while (right > left + 1) {
            int mid = (left + right) / 2;
            if (source[mid] > key) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (right < source.length && source[right] == key) {
            return right + 1;
        }
        if (left > -1 && source[left] == key) {
            return left + 1;
        }
        return 0;
    }
}