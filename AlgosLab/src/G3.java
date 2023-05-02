import java.util.Scanner;

public class G3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            long m = scanner.nextLong();
            if (check(n, m)) {
                System.out.println("Impostors");
                long left = 0;
                long right = n + 1;
                long mid;
                while (right > left + 1) {
                    mid = (left + right) / 2;
                    if (checkTurn(n, m, mid)) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
                if (checkTurn(n, m, left)) {
                    System.out.println(left);
                } else {
                    System.out.println(right);
                }
            } else {
                System.out.println("Crewmates");
                System.out.println(n);
            }
        }

    }

    private static boolean checkTurn(long n, long m, long mid) {
        return ((n + (n - mid + 1)) * (mid) / 2) >= m;
    }

    public static  boolean check(long n, long m) {
        return (n + 1) * (n) / 2 >= m;
    }
}
