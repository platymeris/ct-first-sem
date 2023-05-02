import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));
    }
    public static int[][] multiply(int[][] a, int[][] b) {
        int first = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        int second = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        int third = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        int fourth = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        return new int[][]{{first, second}, {third, fourth}};
    }
    public static int[][] pow(int[][] a, int n) {
        if ( n == 0 || n == 1)
            return a;
        int[][] b = {{1, 1}, {1, 0}};
        a = pow(a, n / 2);
        a = multiply(a, a);
        if (n % 2 != 0) {
            a = multiply(a, b);
        }
        return a;
    }
    public static int fib(int n) {
        int[][] a = {{1, 1}, {1, 0}};
        if (n == 0)
            return 0;
        a = pow(a, n - 1);
        return a[0][0];
    }
}
