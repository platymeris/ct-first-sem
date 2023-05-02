import java.util.*;
import java.io.*;

public class ManagingDifficulties {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n, v, result = 0;
        int[][] tests = new int[t][];
        for(int i = 0; i < t; i++) {
            n = scanner.nextInt();
            tests[i] = new int[n];
            for (int j = 0; j < n; j++){
                tests[i][j] = scanner.nextInt();
            }
        }
        Map<Integer, Integer> kQuantity = new HashMap<>();
        for (int q = 0; q < t; q++) {
            for(int j = tests[q].length - 2; j > 0; j--) {
                if (kQuantity.containsKey(tests[q][j + 1])) {
                    kQuantity.put((tests[q][j + 1]),(kQuantity.get(tests[q][j + 1]) + 1));
                } else {
                    kQuantity.put((tests[q][j + 1]), 1);
                }
                for (int i = 0; i < j; i++) {
                    v = tests[q][j] * 2 - tests[q][i];
                    if (kQuantity.get(v) != null) {
                        result += kQuantity.get(v); 
                    }
                }     
            }
            System.out.println(result);
            result = 0;
            kQuantity.clear();
        }
    }
}