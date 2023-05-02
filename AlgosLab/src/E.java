import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
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
                break;
            }
        }
    }
}
class Queue1 {
    int[] elements;
    int startPointer;
    int endPointer;
    int quantity;
    public Queue1() {
        elements = new int[100];
        startPointer = 0;
        endPointer = 0;
        quantity = 0;
    }
    public void push(int n) {
        elements[endPointer] = n;
        endPointer = (endPointer  + 1)  % 100;
        System.out.println("ok");
        quantity++;
    }
    public void pop() {
        System.out.println(elements[startPointer]);
        startPointer = (startPointer + 1) % 100;
        quantity--;
    }

    public void size() {
        System.out.println(quantity);
    }

    public void clear() {
        startPointer = 0;
        endPointer = 0;
        quantity = 0;
        System.out.println("ok");
    }
    public void exit() {
        System.out.println("bye");
    }

    public void front() {
        System.out.println(elements[startPointer]);
    }
}
