import java.util.*;
import java.io.*;


public class IdealPyramid{

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x, result = 0;
        int[][] obelisks = new int[n][7];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++){
                obelisks[i][j] = scanner.nextInt();
            }
            obelisks[i][3] = obelisks[i][0] - obelisks[i][2];
            obelisks[i][4] = obelisks[i][1] - obelisks[i][2];
            obelisks[i][5] = obelisks[i][0] + obelisks[i][2];
            obelisks[i][6] = obelisks[i][1] + obelisks[i][2];
        }
        double minXl = obelisks[0][3], maxXr = obelisks[0][4], minYl = obelisks[0][5], maxYr= obelisks[0][6];
        for(int i = 0; i < n; i++) {
            if (obelisks[i][3] < minXl) {
                minXl = obelisks[i][3];
            }
            if (obelisks[i][5] > maxXr) {
                maxXr = obelisks[i][5];
            }
            if (obelisks[i][4] < minYl) {
                minYl = obelisks[i][4];
            }
            if (obelisks[i][6] > maxYr) {
                maxYr = obelisks[i][6];
            }
        }
        System.out.println((int)((minXl + maxXr) / 2) +  " " + (int)((minYl + maxYr) / 2) + " " + (int)(Math.ceil((Math.max(maxXr - minXl, maxYr - minYl) / 2))));

    }
}