
import java.io.*;


public class Scanner {
  	int pose = -1;
  	int read = 0; 
  	boolean hasLine = true; 
  	private Reader reader;
  	private char[] buffer = new char[4]; 

	Scanner(InputStream source) throws IOException {
		this.reader = new InputStreamReader(source);
	}

	Scanner(File file) throws IOException {
		this.reader = new InputStreamReader(file, "UTF-8");
	}

	Scanner(String string) throws IOException {
		this.reader = new StringReader(string);		
	}

	char nextChar() throws IOException {
		pose++;
		try {
			if (pose == read || pose == buffer.length) {
				this.read = reader.read(buffer);
				hasLine = false;			
				pose = 0;
			} 	
		} catch (IOException e) {
			System.out.println("Can't read into buffer: " + e.getMessage());
		}
		if (buffer[pose] == '\n' || buffer[pose] == '\r') {
			hasLine = true;
		}	
		return buffer[pose];
	} 

    boolean hasNextChar() {
		boolean b = true; 			
		if (pose >= read && !hasLine) {
			b = false;
		} 
		return b;
	} 

	void close() throws IOException {
		try {
		    reader.close();
		} catch (IOException e) {
			System.out.println("In-Out Exception: " + e.getMessage());
		}
	}

	String nextLine() throws IOException{
		StringBuilder line = new StringBuilder();
		char k = nextChar();
		while (hasNextChar() && k != '\n' && k != '\r') {
			if (k == '\n' || k == '\r') {
				pose--;
				break;
			} else {
				line.append(k);
				k = nextChar();
			}         
		}
		return line.toString();
	}

    boolean hasNextLine() {
    	boolean b = true;
        if (pose >= read) {
            b = false;
        }
        return b && hasLine;
    }

	int nextInt() throws IOException {
		StringBuilder number = new StringBuilder();
		char k = buffer[pose];
		while (hasNextChar() && (Character.isDigit(k) || k == '-')) {
			number.append(k);
			k = nextChar();
		}
		return Integer.parseInt(number.toString());
	}

	boolean hasNextInt() throws IOException {
		boolean b = false;
		while (hasNextChar()) {
			char k = nextChar();
			if (Character.isDigit(k) || k == '-') {
				b = true;
				break;
			}
		}
		return b;
	} 

	int nextIntOct() throws IOException {
		StringBuilder number = new StringBuilder();
		char k = buffer[pose];
		while (hasNextChar() && (Character.isDigit(k) || k == '-' || k == 'o' || k == 'O')) {
			number.append(k);
			k = nextChar();
		}
		long num = 0;
		if (number.charAt(number.length() - 1) == 'o' || number.charAt(number.length() - 1) == 'O') {
			number.deleteCharAt(number.length() - 1);
			num = Integer.parseUnsignedInt(number.toString(), 8);
		} else {
			num = Integer.parseInt(number.toString());
		}
		return (int) num;
	}

	String nextWord() throws IOException {
		StringBuilder word = new StringBuilder();
		char k = nextChar();
		while (hasNextChar() && (Character.isLetter(k) || Character.getType(k) == 
			Character.DASH_PUNCTUATION || k == '\'')) {
			word.append(k);
			k = nextChar();
		}
		return word.toString();
	}

	boolean hasNextWord() throws IOException {
		boolean b = false;
		while (hasNextChar()) {
			char k = nextChar();
			if ((Character.isLetter(k) || Character.getType(k) == 
			Character.DASH_PUNCTUATION || k == '\'')) {				
				b = true;
				pose--;
				break;
			}
		}
		return b;
	} 
}