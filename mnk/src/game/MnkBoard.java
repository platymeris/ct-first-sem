package game;

import java.util.Arrays;
import java.util.Map;

public class MnkBoard implements Board, Position {
    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );
    private int turnQuantity = 0;
    private final Cell[][] field;
    private Cell turn;
    private final int m;
    private final int n;
    private final int k;


    public MnkBoard(int m, int n, int k) {
        field = new Cell[m][n];
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
        this.m = m;
        this.n = n;
        this.k = k;
    }
    @Override
    public void clearBoard() {
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
        turnQuantity = 0;
    }
    @Override
    public Cell getTurn() {
        return turn;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public GameResult makeMove(Move move) {
        if (!isValid(move)) {
            return GameResult.LOOSE;
        }
        turnQuantity++;
        field[move.getRow()][move.getCol()] = move.getValue();
        if (checkWin(move, k)) {
            return GameResult.WIN;
        }

        if (checkDraw()) {
            return GameResult.DRAW;
        }
        if (!checkWin(move, 2)) {
            turn = turn == Cell.X ? Cell.O : Cell.X;
        }
        return GameResult.UNKNOWN;
    }

    private boolean checkDraw() {
        return turnQuantity == m * n;
    }

    private boolean check(Move move, int FIRST, int SECOND, int k) {
        int count = 1;
        boolean downFlag = true;
        boolean upFlag = true;
        for (int d = 1; d < k; d++) {
            if (upFlag && (move.getRow() + (FIRST * d) < m) && (move.getRow() + (FIRST * d) >= 0)
                    && (move.getCol() - (SECOND * d) < n) && (move.getCol() - (SECOND * d)) >= 0 &&
                    (field[move.getRow() + (FIRST * d)][move.getCol() - (SECOND * d)] == turn)) {
                count++;
            } else {
                upFlag = false;
            }
            if (downFlag && (move.getRow() - (FIRST * d)) >= 0 && move.getRow() - (FIRST * d) < m  && (move.getCol() + (SECOND * d)) >= 0
                    && (move.getCol() +  (SECOND * d)) < n &&
                    (field[move.getRow() - (FIRST * d)][move.getCol() + (SECOND * d)] == turn)) {
                count++;
            } else {
                downFlag = false;
            }
        }
        return (count >= k);
    }
    private boolean checkWin(Move move, int k) {
        return (check(move, 1, 0, k) | check(move,0, 1, k)
               | check(move, 1, 1, k) | check(move, -1, 1, k));
    }
    public boolean isValid(final Move move) {
        return 0 <= move.getRow() && move.getRow() < m
                && 0 <= move.getCol() && move.getCol() < n
                && field[move.getRow()][move.getCol()] == Cell.E
                && turn == move.getValue();
    }

    @Override
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("  ");
        for (int i = 1; i <= n; i++) {
            sb.append(i).append(" ");
        }
        sb.append(System.lineSeparator());
        for (int r = 0; r < m; r++) {
            sb.append(r + 1).append(" ");
            for (Cell cell : field[r]) {
                sb.append(CELL_TO_STRING.get(cell)).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length() - System.lineSeparator().length());
        return sb.toString();
    }
}
