import java.util.Arrays;
import java.io.*;

//import java.util.Scanner;

public class Reverse {

    public static void main(String[] args) {
        int firstLength = 1, secondLength = 1, maxLength = 1, i = 0, j = 0;
        int[][] storage = new int[firstLength][secondLength];
        int[][] secondStorage;
        int[] copyPlace;
        int sFlag = 1;
        if (System.lineSeparator().equals("\r\n")) {
            sFlag = 2;
        }
        try {
            Scanner scanner = new Scanner(System.in);
            try {
                while (scanner.hasNextLine()) {
                    if (i >= storage.length) {
                        storage = Arrays.copyOf(storage, storage.length*2);
                        firstLength *= 2;
                    }
                    Scanner currentLine = new Scanner(scanner.nextLine());
                    storage[i] = new int[secondLength + 1];
                    while  (currentLine.hasNextInt()) {
                        if (secondLength > j) {
                            storage[i][j] = currentLine.nextInt();
                        }
                        else {
                            storage[i] = Arrays.copyOf(storage[i], storage[i].length*2 + 1);
                            secondLength *= 2;
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
            } finally {
                scanner.close();
            }
        } catch(IOException e) {
            System.out.println("Reading error: " + e.getMessage());
        }
        for (int k = i - sFlag; k >= 0; k--) {
            for (int z = storage[k][storage[k].length - 1] - 1; z >= 0; z--) {
                System.out.print(storage[k][z] + " ");
            }
            System.out.println("");
        }
    }
}