import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Y {
    private static long[][][] powers;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        powers = new long[(int)Math.log(n) + 1][2][2];
        Arrays.fill(powers, null);
        long[][] source = {{1, 1}, {1, 0}};
    }

    public static long[][] matrixMultiply(long[][] x, long[][] y) {
        long[][] result = new long[2][2];
        result[0][0] = x[0][0] * y[0][0] + x[0][1] * y[1][0];
        result[0][1] = x[0][0] * y[0][1] + x[0][1] * y[1][1];
        result[1][0] = x[1][0] * y[0][0] + x[1][1] * y[1][0];
        result[1][1] = x[1][0] * y[0][1] + x[1][1] * y[1][1];
        return result;
    }

    public static long[][] matrixPow( long[][]x,  long pow) {
        if (pow == 1) {
            return x;
        }
        if (powers[(int)pow] != null) {
            return powers[(int) pow];
        }
        long[][] K = matrixPow(x, pow / 2);
        long[][] R = matrixMultiply(K, K);
        powers[(int)pow] = R;
        return R;
    }

    public static Constable get_number(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long[] power = new long[(int) n];


        long[][][] matrices = new long[power.length][2][2];
        long[][] Q = {{1, 1}, {1, 0}};
        for (int i = 0; i < power.length; i++) {
            matrices[i] = matrixPow(Q, power[i]);
        }
        return null;
    }
}

