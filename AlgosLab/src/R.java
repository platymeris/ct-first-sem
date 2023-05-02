import java.util.Scanner;

public class R {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = i + 1;
        }
        for (int i = 2; i < n; i++){
            swap(source, i, i / 2);
        }
        for (int i: source) {
            System.out.print(i + " ");
        }

    }
    public static void swap(int[] source, int x, int y)  {
        int temp = source[x];
        source[x] = source[y];
        source[y] = temp;
    }
}
