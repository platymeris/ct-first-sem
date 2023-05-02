import java.util.*;
import java.io.*;


public class AccurateMovement{

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println((int)(2 * Math.ceil((n - b) / (b - a)) + 1)); 
    }
}