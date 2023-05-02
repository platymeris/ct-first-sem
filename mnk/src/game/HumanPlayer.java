package game;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(Scanner in) {
        this.in = in;
    }

    @Override
    public Move makeMove(Position position) {
        System.out.println();
        System.out.println("Current position");
        System.out.println(position);
        System.out.println("Enter your move for " + position.getTurn());
        while (true) {
            Scanner inLine = new Scanner(in.nextLine());
            int row = -1, col = -1;
            if (inLine.hasNextInt()) {
                row = inLine.nextInt();
                if (inLine.hasNextInt()) {
                    col = inLine.nextInt();
                }
            }
            final Move move = new Move(row - 1, col - 1, position.getTurn());
            if (position.isValid(move) && !inLine.hasNext()) {
                return move;
            }
            System.out.println("Your move is not allowed. Please enter another one.");
        }
    }
}
