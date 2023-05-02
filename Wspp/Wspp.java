import java.util.*;
import java.io.*;

public class Wspp {
    public static void main(String[] args) {
        int start, quantity = 0;
        Map<String, IntList> storage = new LinkedHashMap<>();
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            try {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    for (int j = 0; j < line.length(); j++) {
                        if ((Character.getType(line.charAt(j)) ==  Character.DASH_PUNCTUATION) | 
                            (Character.isLetter(line.charAt(j))) | (line.charAt(j) ==  '\'')) {
                            start = j;
                            while ((j < line.length()) && 
                                (Character.getType(line.charAt(j)) ==  Character.DASH_PUNCTUATION) | 
                                (Character.isLetter(line.charAt(j))) | (line.charAt(j) ==  '\'')) {
                                j++;
                            } 
                            String currentWord = line.substring(start, j).toLowerCase();
                            quantity++;
                            if (storage.containsKey(currentWord)) {
                                storage.get(currentWord).add(quantity);
                            } else {
                                storage.put((currentWord), new IntList());
                                storage.get(currentWord).add(quantity);
                            }
                        }
                    }
                }
            } finally {
                scanner.close();
            }
        } catch(IOException e) {
            System.out.println("File reading error: " + e.getMessage());

       }
        try {      
           BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(args[1]),
                    "utf8"
                )
            );
            try {
                for(String key : storage.keySet()) {
                    writer.write(key + " " + storage.get(key).getLength() + " " + storage.get(key));
                    writer.newLine();
                }
            } finally {
                writer.close();
            }
        } catch(IOException e) {
            System.out.println("File reading error: " + e.getMessage());

       } 
    }
}