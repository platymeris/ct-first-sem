import java.io.*;

public class Test {	
	public static void main(String[] args) throws IOException{
	    char[] buffer = new char[512];
	    Scanner scanner = new Scanner(System.in);
        while (scanner.lineHasNextChar()){
            System.out.println(scanner.nextChar());
        }
    }
}