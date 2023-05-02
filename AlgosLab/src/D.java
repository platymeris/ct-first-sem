import java.util.Scanner;

public class D {
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
            System.out.println(binSearch(source, i) ? "YES" : "NO");
        }
    }

    public static boolean binSearch(int[] source, int key) {
        int left = 0;
        int right = source.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (source[mid] == key) {
                return true;
            } else {
                if (key < source[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
