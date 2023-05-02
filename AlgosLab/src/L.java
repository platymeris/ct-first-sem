import java.util.Arrays;
import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        int[] source = new int[200000];
        int[] keyElement = new int[200000];
        int[] exp = new int[200000];
        Arrays.fill(exp, 0);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            source[i] = scanner.nextInt();
            keyElement[i] = source[i];
        }
        for (int i = 0; i < m; i++) {
            String command = scanner.nextLine();
            if (command.startsWith("join")) {
                for (int j = 0; j < 0; j++) {

                }
            } else if (command.startsWith("add")) {

            } else if (command.startsWith("get")) {

            }
        }

    }
}

