import java.io.*;

public class Scanner {

    private Reader reader;
    private int bufferSize = 8;
    private char[] buffer = new char[bufferSize];
    private int read = 0;
    private int position = -1;
    private boolean lineChange = true;  
    
    public void bufferUpdate() throws IOException{
        read = reader.read(buffer);
    }

    Scanner(InputStream source) throws IOException{
        reader = new InputStreamReader(source);
    }

    Scanner(String source) {
         reader = new StringReader(source);
    }

    Scanner(File source) throws IOException{
        reader = new InputStreamReader(new FileInputStream(source), "utf8");
    }

    public char[] getBuffer() {
        char[] tempBuffer = this.buffer;
        return (tempBuffer);
    }

    public char nextChar() throws IOException{
        position++;
        if (position == bufferSize || position == read) {
            bufferUpdate();
            lineChange = false;
            position = 0;
        }
        if (buffer[position] == ('\n') || buffer[position] == ('\r')) {
            lineChange = true; 
        }
        return(buffer[position]);
    }

    public boolean hasNextChar() {
        boolean result = true;
        if (position >= read) {
            result = false;
        }
        return(result);
    }

    public void close() throws IOException{
        this.reader.close();
    }

    public boolean hasNextLine() {
        boolean result = true;
        if (position >= read) {
            result = false;
        }
        return(this.hasNextChar() && lineChange);
    }

    public String nextLine() throws IOException{
        char currentChar = this.nextChar();
        StringBuilder line = new StringBuilder();
        while ((Character.getType(currentChar)) != Character.getType('\n') && this.hasNextChar()) {
            line.append(currentChar);
            currentChar = this.nextChar();
        }
        if (this.hasNextChar() && !((this.nextChar() == '\n') && currentChar == '\r')) {
            position--;
            lineChange = true;
        }
        return line.toString();
    }

    public boolean hasNextInt() throws IOException{
        while (this.hasNextChar()) {
            char currentChar = this.nextChar();
            if (Character.isDigit(currentChar) || currentChar == '-') {
                position--;            
                return true; 
            }
        }
        return false;
    }

    public int nextInt() throws IOException{
        char currentChar = this.nextChar();
        while (Character.isDigit(currentChar) == false && currentChar != '-') {
            currentChar = this.nextChar();
        }
        StringBuilder number = new StringBuilder();
        while((Character.isDigit(currentChar) || currentChar == '-') && this.hasNextChar()) {
            number.append(currentChar);
            currentChar = this.nextChar();
        }
        return Integer.parseInt(number.toString());
    }

    public boolean hasNextWord() throws IOException{
        while (this.hasNextChar()) {
            char currentChar = this.nextChar();
            if (Character.isAlphabetic(currentChar) || Character.getType(currentChar) == Character.DASH_PUNCTUATION) {
                position--;            
                return true; 
            }
        }
        return false;
    }

    public String nextWord() throws IOException{
        char currentChar = this.nextChar();
        while (Character.isAlphabetic(currentChar) == false && Character.getType(currentChar) != Character.DASH_PUNCTUATION) {
            currentChar = this.nextChar();
        }
        StringBuilder number = new StringBuilder();
        while((Character.isAlphabetic(currentChar) || Character.getType(currentChar) == Character.DASH_PUNCTUATION) && this.hasNextChar()) {
            number.append(currentChar);
            currentChar = this.nextChar();
        }
        return number.toString();
    }

} 