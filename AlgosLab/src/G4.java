import java.util.Scanner;

public class G4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue first = new Queue();
        Queue second = new Queue();
        for (int i = 0; i < 5; i++) {
            int temp = scanner.nextInt();
            first.push(temp);
        }
        for (int i = 0; i < 5; i++) {
            int temp = scanner.nextInt();
            second.push(temp);
        }
        int i = 0;
        boolean flag = false;
        while (first.size() != 0 & second.size() != 0) {
            int firstCard = first.pop();
            int secondCard = second.pop();
            if ((firstCard > secondCard | (firstCard == 0 & secondCard == 9)) & !(firstCard == 9 & secondCard == 0)) {
                first.push(firstCard);
                first.push(secondCard);
            } else {
                second.push(firstCard);
                second.push(secondCard);
            }
            i++;
            if (i > 1000000) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("botva");
        } else if (first.size() == 0){
            System.out.println("second" + " " + i);
        } else {
            System.out.println("first" + " " + i);
        }
    }
}
class Queue {
    int[] elements;
    int startPointer;
    int endPointer;
    int quantity;
    public Queue() {
        elements = new int[100];
        startPointer = 0;
        endPointer = 0;
        quantity = 0;
    }
    public void push(int n) {
        elements[endPointer] = n;
        endPointer = (endPointer  + 1)  % 100;
        quantity++;
    }
    public int pop() {
        int result = elements[startPointer];
        startPointer = (startPointer + 1) % 100;
        quantity--;
        return result;
    }

    public int size() {
        return quantity;
    }

    public void clear() {
        startPointer = 0;
        endPointer = 0;
        quantity = 0;
    }
    public int front() {
        return elements[startPointer];
    }
}
