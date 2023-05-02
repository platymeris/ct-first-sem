import java.util.Scanner;

public class C3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] source = new double[n];
        source[0] = scanner.nextDouble();
        double left = 0;
        double right = source[0];
        double last = -1;
        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;
            double previous = source[0];
            double current = mid;
            boolean flag = current > 0;
            for (int j = 2; j < n; j++) {
                 double next = 2 * current - previous + 2;
                 flag = flag & next > 0;
                 previous = current;
                 current = next;
            }
            if (flag) {
                right = mid;
                last = current;
            } else {
                left = mid;
            }
        }
        System.out.println(last);
    }
}
