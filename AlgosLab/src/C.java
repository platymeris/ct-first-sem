import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack1 queue = new Stack1();
        while (true) {
            String command = scanner.nextLine();
            if (command.startsWith("push")) {
                queue.push(Integer.parseInt(command.substring(5)));
            } else if (command.startsWith("pop")) {
                queue.pop();
            } else if (command.startsWith("front")) {
                queue.front();
            } else if (command.startsWith("size")) {
                queue.size();
            } else if (command.startsWith("clear")) {
                queue.clear();
            } else if (command.startsWith("exit")) {
                queue.exit();
                break;
            }
        }
    }
}

class Stack1 {
    int[] elements;
    int pointer;
    public Stack1() {
        elements = new int[100];
        pointer = 0;
    }
    public void push(int n) {
        elements[pointer] = n;
        pointer++;
        System.out.println("ok");
    }
    public void pop() {
        pointer--;
        System.out.println(elements[pointer]);
    }
    public void back() {
        System.out.println(elements[pointer - 1]);
    }

    public void size() {
        System.out.println(pointer);
    }

    public void clear() {
        pointer = 0;
        System.out.println("ok");
    }
    public void exit() {
        System.out.println("bye");
    }

    public void front() {
    }
}
