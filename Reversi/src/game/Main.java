package game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int result = new TwoPlayerGame(
                new ReversiBoard(4, 4),
                new HumanPlayer(scanner),
                new RandomPlayer(4, 4)
        ).play(true);
        switch (result) {
            case 1:
                System.out.println("First player won");
                break;
            case 2:
                System.out.println("Second player won");
                break;
            case 0:
                System.out.println("Draw");
                break;
            default:
                throw new AssertionError("Unknown result " + result);
        }
    }
}
