import java.util.*;
import java.io.*;


public class JustTheLastDigit{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] roads = new String[n];
        int[][] graph = new int[n][n];
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            roads[i]= scanner.next("")
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                graph[i][n - 1 - j] = Integer.parseInt(roads[i].substring(j, j + 1));

            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 0;
                } else {
                    for(int k = j + 1; k < n; k++) {
                        graph[i][k] = Math.abs((graph[i][k] - graph[j][k]) % 10);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println("");
        }
    }
}