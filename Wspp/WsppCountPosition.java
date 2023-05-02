import java.util.*;
import java.io.*;

public class WsppCountPosition {
    public static void main(String[] args) {
        int start, quantity, i = 0;
        Map<String, IntList> storage = new LinkedHashMap<>();
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            try {
                while (scanner.hasNextLine()) {
                    i++;
                    quantity = 0;
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
                                storage.get(currentWord).add(i);
                                storage.get(currentWord).add(quantity);
                            } else {
                                storage.put((currentWord), new IntList());
                                storage.get(currentWord).add(i);
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
        String[] order = new String[storage.keySet().size()];
        int k = 0;
        for (String key : storage.keySet()) {
            order[k] = key;
            k++;
        }
        order = sort(order, storage);
        try {      
           BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(args[1]),
                    "utf8"
                )
            );
            try {
                for (String key : order) {
                    writer.write(key + " " + storage.get(key).getLength()/2 + " ");
                    for (int z = 0; z < storage.get(key).getLength(); z+=2) {
                        if (z == storage.get(key).getLength() - 2) {
                            writer.write(storage.get(key).getElement(z)+ ":" 
                            + storage.get(key).getElement(z+1));
                        } else {
                            writer.write(storage.get(key).getElement(z)+ ":" 
                            + storage.get(key).getElement(z+1) + " ");  
                        }
                    }
                    writer.newLine();
                }
            } finally {
                writer.close();
            }
        } catch(IOException e) {
            System.out.println("File reading error: " + e.getMessage());

       } 
    }
    public static String[] merge(Map<String, IntList> map, String[] firstArray, String[] secondArray) {
        int n = firstArray.length;
        int m = secondArray.length;
        String[] c = new String[n+m];
        int i = 0, j = 0;
        while (i < n || j < m) {
            if (j == m) {
                c[i + j] = firstArray[i];
                i++;
            } else if (i == n) {
                c[i + j] = secondArray[j];
                j++;
            } else if (map.get(firstArray[i]).getLength() <= map.get(secondArray[j]).getLength()) {
                c[i + j] = firstArray[i];
                i++;
            } else {
                c[i + j] = secondArray[j];
                j++;
            }
        }
        return c;
    }
    public static String[] sort(String[] array, Map<String, IntList> map) {
        int n = array.length;
        if (n <= 1) {
            return(array);
        } else {
            String[] a1 = Arrays.copyOfRange(array, 0, n/2);
            String[] a2 = Arrays.copyOfRange(array, n/2, n);
            return merge(map, sort(a1, map), sort(a2, map));
        }
    }
}