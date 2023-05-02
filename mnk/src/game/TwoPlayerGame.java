package game;

import java.util.HashMap;
import java.util.Map;

public class TwoPlayerGame {
    private final Board board;
    private final Map <Integer, Player> players;

    private int order = 0;

    public TwoPlayerGame(Board board, Player player1, Player player2) {
        this.board = board;
        players = new HashMap<>(Map.of(1, player1, 2, player2));
    }

    public int play(boolean log) {
        while (true) {
            final int result1 = makeMove(players.get(1 + getOrder()), 1 + getOrder(), log);
            if (result1 != -1)  {
                return result1;
            }

            final int result2 = makeMove(players.get(2 - getOrder()), 2 - getOrder(), log);
            if (result2 != -1)  {
                return result2;
            }
        }
    }
    public int playMatch(int points, boolean log) {
        System.out.println("Starting match till " + points + " points. ");
        int firstPlayerPoints = 0;
        int secondPlayerPoints = 0;
        while (firstPlayerPoints < points && secondPlayerPoints < points) {
            int startOrder = getOrder();
            int gameResult = this.play(log);
            switch (gameResult) {
                case 1:
                    firstPlayerPoints += 1;
                    System.out.println("\nFirst player won this game.");
                    break;
                case 2:
                    secondPlayerPoints += 1;
                    System.out.println("\nSecond player won this game.");
                    break;
                case 0:
                    System.out.println("\nDraw");
                    break;
                default:
                    throw new AssertionError("Unknown result " + gameResult);
            }
            this.board.clearBoard();
            order = 1 - startOrder;
            System.out.println("\n Current points\nFirst player: " + firstPlayerPoints +
                    "\nSecond player: " + secondPlayerPoints);
        }
        if (firstPlayerPoints == points) {
            return 1;
        } else if (secondPlayerPoints == points){
            return 2;
        } else {
            return -1;
        }
    }
    private int makeMove(Player player, int no, boolean log) {
        GameResult result;
        try {
            final Move move = player.makeMove(board.getPosition());
            final Cell startPosition = board.getPosition().getTurn();
            result = board.makeMove(move);
            final Cell finishPosition = board.getPosition().getTurn();
            if (startPosition == finishPosition && result == GameResult.UNKNOWN) {
                order = 1 - getOrder();
            }
            if (log) {
                System.out.println();
                System.out.println("Player: " + no);
                System.out.println(move);
                System.out.println(board);
                System.out.println("Result: " + result);
            }
        } catch (Exception e) {
            result = GameResult.LOOSE;
        }
        switch (result) {
            case WIN:
                return no;
            case LOOSE:
                return 3 - no;
            case DRAW:
                return 0;
            case UNKNOWN:
                return -1;
            default:
                throw new AssertionError("Unknown makeMove result " + result);
        }
    }

    public int getOrder() {
        return order;
    }
}
