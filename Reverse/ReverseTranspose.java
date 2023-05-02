import java.util.Arrays;
import java.util.Scanner;

public class ReverseTranspose {

    public static void main(String[] args) {
        int firstLength = 1, secondLength = 1, maxLength = 1, i = 0, j = 0;
        int[][] storage = new int[firstLength][secondLength];
        int[][] secondStorage;
        int[] copyPlace;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            if (i >= firstLength) {
                copy2d(storage, secondStorage = new int[firstLength][secondLength]);
                firstLength *= 2;
                storage = new int[firstLength][secondLength];
                copy2d(secondStorage, storage);
            }
            Scanner currentLine = new Scanner(scanner.nextLine());
            storage[i] = new int[secondLength + 1];
            while  (currentLine.hasNextInt()) {
                if (secondLength > j) {
                    storage[i][j] = currentLine.nextInt();
                }
                else {
                    copy(storage[i], copyPlace = new int[secondLength + 1]);
                    secondLength *= 2;
                    storage[i] = new int[secondLength + 1];
                    copy(copyPlace, storage[i]);
                    storage[i][j] = currentLine.nextInt();
                }
                j++;
            }
            storage[i][storage[i].length - 1] = j;
            if (j > maxLength) {
                maxLength = j;
            }
            secondLength = 1;
            j = 0;
            i++;
        }
        for (int k = 0; k < maxLength; k++) {
            for (int z = 0; z < i; z++) {
                if (storage[z][storage[z].length - 1] >= k + 1) {
                    System.out.print(storage[z][k] + " ");
                } 
            }
            System.out.println("");
        }
    }

    public static void copy(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i]; 
        }
    }

    public static void copy2d(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i]; 
        }
    }
}