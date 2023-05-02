import java.util.*;
import java.io.*;

class IntList {
    private int length = 0;
    public int [] array;

    IntList() {
        array = new int[1];
    }

    public void add(int i) {
        if (array.length <= this.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        length++;
        array[length - 1] = i;
    }

    public int getLength() {
        return length;
    }

    public int getElement(int i) {
        return(array[i]);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < length; i++) {
            string.append(array[i]);
            string.append(" ");
        }
        string.deleteCharAt(string.length() - 1);
        return string.toString();
    }
}