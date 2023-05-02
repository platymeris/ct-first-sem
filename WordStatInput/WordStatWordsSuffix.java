import java.util.*;
import java.io.*;

public class WordStatWordsSuffix {
    public static void main(String[] args) {
        int i = 0, start = 0, mark = -1, temp = 0;
        boolean notSort = true;
        String time = "";
        String[] storage = new String[1];
        int[] quantity = new int[1];
        try { 
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(args[0]), "utf8")
            );
            try {
                String line = reader.readLine();
                while (line != null) {
                    for (int j = 0; j < line.length(); j++) {
                        if ((Character.getType(line.charAt(j)) ==  Character.DASH_PUNCTUATION) | 
                            (Character.isLetter(line.charAt(j))) | (line.charAt(j) ==  '\'')) {
                            start = j;
                        
                            while ((j < line.length()) && 
                            	(Character.getType(line.charAt(j)) ==  Character.DASH_PUNCTUATION) | 
                                (Character.isLetter(line.charAt(j))) | (line.charAt(j) ==  '\'')) {
                                j++;
                            }
                            if (j - start < 3) {
                                start = start;
                            } else {
                                start = j - 3;
                            }
                            if (i == storage.length) {
                                storage = Arrays.copyOf(storage, storage.length*2);
                                quantity = Arrays.copyOf(quantity, quantity.length*2);
                            }
                            for (int z = 0; z < i; z++) {
                            	if (storage[z].equals(line.substring(start, j).toLowerCase())) {
                            		mark = z;
                            	}
                            }
                            if (mark == -1) {
                                storage[i] = line.substring(start, j).toLowerCase();
                                quantity[i] = 1;
                                i++;
                            } else {
                            	quantity[mark] += 1;
                            }
                            mark = -1;
                        }
                    }
                    line = reader.readLine();
                    start = 0;
                }
            } finally {
                reader.close();
            }
        } catch(IOException e) {
            System.out.println("File reading error: " + e.getMessage());

	   }
       while (notSort) {
            notSort = false;
            for (int j = 1; j < i; j++) {
                if (storage[j - 1].compareTo(storage[j]) > 0) {
                    temp = quantity[j];
                    quantity[j] = quantity[j - 1];
                    quantity[j - 1] = temp;
                    time = storage[j];
                    storage[j] = storage[j - 1];
                    storage[j - 1] = time;
                    notSort = true;
                }
            }
        }
        
        try {	   
		   BufferedWriter writer = new BufferedWriter(
	            new OutputStreamWriter(
	                new FileOutputStream(args[1]),
	                "utf8" 
	            )
	        );
	        try {
		        for (int s = 0; s < i; s++) {
		        	writer.write(storage[s] + " " + quantity[s]);
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