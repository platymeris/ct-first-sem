package game;

import java.util.Arrays;
import java.util.Map;

public class ReversiBoard implements Board, Position {
    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "●",
            Cell.O, "○"
    );
    private int turnQuantity = 0;
    private final Cell[][] field;
    private Cell turn;
    private final int m;
    private final int n;


    public ReversiBoard(int m, int n) {
        field = new Cell[m][n];
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
        this.m = m;
        this.n = n;
        field[m / 2][n / 2] = Cell.O;
        field[m / 2 - 1][n / 2] = Cell.X;
        field[m / 2][n / 2 - 1] = Cell.X;
        field[m / 2 - 1][n / 2 - 1] = Cell.O;
    }
    @Override
    public void clearBoard() {
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
        turnQuantity = 0;
        field[m / 2][n / 2] = Cell.O;
        field[m / 2 - 1][n / 2] = Cell.X;
        field[m / 2][n / 2 - 1] = Cell.X;
        field[m / 2 - 1][n / 2 - 1] = Cell.O;
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
        if (move.getRow() > 1 && move.getCol() > 1 && field[move.getRow() - 1][move.getCol() - 1] != move.getValue() && field[move.getRow() - 1][move.getCol() - 1] != Cell.E) {
            int i = 1;
            while (move.getRow() - i >= 0 && move.getCol() - i >= 0 && field[move.getRow() - i][move.getCol() - i] != move.getValue() && field[move.getRow() - i][move.getCol() - i] != Cell.E) {
                i++;
            }
            if (move.getRow() - i >= 0 && move.getCol() - i >= 0 && field[move.getRow() - i][move.getCol() - i] == move.getValue()) {
                for (int j = 0; j < i; j++) {
                    field[move.getRow() - j][move.getCol() - j] = move.getValue();
                }
            }
        }

        if (move.getRow() > 1 && move.getCol() < n - 2 && field[move.getRow() - 1][move.getCol() + 1] != move.getValue() && field[move.getRow() - 1][move.getCol() + 1] != Cell.E) {
            int i = 1;
            while (move.getRow() - i >= 0 && move.getCol() + i < n && field[move.getRow() - i][move.getCol() + i] != move.getValue() && field[move.getRow() - i][move.getCol() + i] != Cell.E) {
                i++;
            }
            if (move.getRow() - i >= 0 && move.getCol() + i < n && field[move.getRow() - i][move.getCol() + i] == move.getValue()) {
                for (int j = 0; j < i; j++) {
                    field[move.getRow() - j][move.getCol() + j] = move.getValue();
                }
            }
        }

        if (move.getRow() < m - 2 && move.getCol() < n - 2 && field[move.getRow() + 1][move.getCol() + 1] != move.getValue() && field[move.getRow() + 1][move.getCol() + 1] != Cell.E) {
            int i = 1;
            while (move.getRow() + i < m && move.getCol() + i < n && field[move.getRow() + i][move.getCol() + i] != move.getValue() && field[move.getRow() + i][move.getCol() + i] != Cell.E) {
                i++;
            }
            if (move.getRow() + i < m && move.getCol() + i < n && field[move.getRow() + i][move.getCol() + i] == move.getValue()) {
                for (int j = 0; j < i; j++) {
                    field[move.getRow() + j][move.getCol() + j] = move.getValue();
                }
            }
        }

        if (move.getRow() < m - 2 && move.getCol() > 1 && field[move.getRow() + 1][move.getCol() - 1] != move.getValue() && field[move.getRow() + 1][move.getCol() - 1] != Cell.E) {
            int i = 1;
            while (move.getRow() + i < m && move.getCol() - i >= 0 && field[move.getRow() + i][move.getCol() - i] != move.getValue() && field[move.getRow() + i][move.getCol() - i] != Cell.E) {
                i++;
            }
            if (move.getRow() + i < m && move.getCol() - i >= 0 && field[move.getRow() + i][move.getCol() - i] == move.getValue()) {
                for (int j = 0; j < i; j++) {
                    field[move.getRow() + j][move.getCol() - j] = move.getValue();
                }
            }
        }

        if (move.getRow() > 1 && field[move.getRow() - 1][move.getCol()] != move.getValue() && field[move.getRow() - 1][move.getCol()] != Cell.E) {
            for (int i = move.getRow() - 1; i >= 0; i--) {
                if (field[i][move.getCol()] == Cell.E) {
                    break;
                }
                if (field[i][move.getCol()] == move.getValue()) {
                    for (int j = move.getRow() - 1; j > i; j--) {
                        field[j][move.getCol()] = move.getValue();
                    }
                }
            }
        }

        if (move.getRow() < m - 2 && field[move.getRow() + 1][move.getCol()] != move.getValue() && field[move.getRow() + 1][move.getCol()] != Cell.E) {
            for (int i = move.getRow() + 1; i < m; i++) {
                if (field[i][move.getCol()] == Cell.E) {
                    break;
                }
                if (field[i][move.getCol()] == move.getValue()) {
                    for (int j = move.getRow() + 1; j < i; j++) {
                        field[j][move.getCol()] = move.getValue();
                    }
                }
            }
        }

        if (move.getCol() > 1 && field[move.getRow()][move.getCol() - 1] != move.getValue() && field[move.getRow()][move.getCol() - 1] != Cell.E) {
            for (int i = move.getCol() - 1; i >= 0; i--) {
                if (field[move.getRow()][i] == Cell.E) {
                    break;
                }
                if (field[move.getRow()][i] == move.getValue()) {
                    for (int j = move.getCol() - 1; j > i; j--) {
                        field[move.getRow()][j] = move.getValue();
                    }
                }
            }
        }

        if (move.getCol() < n - 2  && field[move.getRow()][move.getCol() + 1] != move.getValue() && field[move.getRow()][move.getCol() + 1] != Cell.E) {
            for (int i = move.getCol() + 1; i < n; i++) {
                if (field[move.getRow()][i] == Cell.E) {
                    break;
                }
                if (field[move.getRow()][i] == move.getValue()) {
                    for (int j = move.getCol() + 1; j < i; j++) {
                        field[move.getRow()][j] = move.getValue();
                    }
                }
            }
        }


        if (checkMoveAvailability()) {
            turn = turn == Cell.X ? Cell.O : Cell.X;
            return GameResult.UNKNOWN;
        }
        int blackQuantity = 0;
        int whiteQuantity = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == Cell.X) {
                    blackQuantity++;
                }
                if (field[i][j] == Cell.O) {
                    whiteQuantity++;
                }
            }
        }
        if (blackQuantity > whiteQuantity) {
            if (move.getValue() == Cell.X) {
                return GameResult.WIN;
            } else {
                return GameResult.LOOSE;
            }
        }
        if (blackQuantity < whiteQuantity) {
            if (move.getValue() == Cell.O) {
                return GameResult.WIN;
            } else {
                return GameResult.LOOSE;
            }
        }
        if (checkDraw()) {
            return GameResult.DRAW;
        }
        return GameResult.UNKNOWN;
    }

    private boolean checkDraw() {
        return turnQuantity == m * n;
    }

    private boolean checkMoveAvailability() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                Move move = new Move(i, j, Cell.X);
                if (isValid(move)) {
                    return true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                Move move = new Move(i, j, Cell.O);
                if (isValid(move)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isValid(final Move move) {
        if (move.getCol() < 0 || move.getRow() < 0 || move.getCol() >= n || move.getRow() >= m) {
            return false;
        }
        if (field[move.getRow()][move.getCol()] != Cell.E) {
            return false;
        }
        if (move.getRow() > 1 && move.getCol() > 1 && field[move.getRow() - 1][move.getCol() - 1] != move.getValue() && field[move.getRow() - 1][move.getCol() - 1] != Cell.E) {
            int i = 1;
            while (move.getRow() - i >= 0 && move.getCol() - i >= 0 && field[move.getRow() - i][move.getCol() - i] != move.getValue() && field[move.getRow() - i][move.getCol() - i] != Cell.E) {
                i++;
            }
            if (move.getRow() - i >= 0 && move.getCol() - i >= 0 && field[move.getRow() - i][move.getCol() - i] == move.getValue()) {
                return true;
            }
        }

        if (move.getRow() > 1 && move.getCol() < n - 2 && field[move.getRow() - 1][move.getCol() + 1] != move.getValue() && field[move.getRow() - 1][move.getCol() + 1] != Cell.E) {
            int i = 1;
            while (move.getRow() - i >= 0 && move.getCol() + i < n && field[move.getRow() - i][move.getCol() + i] != move.getValue() && field[move.getRow() - i][move.getCol() + i] != Cell.E) {
                i++;
            }
            if (move.getRow() - i >= 0 && move.getCol() + i < n && field[move.getRow() - i][move.getCol() + i] == move.getValue()) {
                return true;
            }
        }

        if (move.getRow() < m - 2 && move.getCol() < n - 2 && field[move.getRow() + 1][move.getCol() + 1] != move.getValue() && field[move.getRow() + 1][move.getCol() + 1] != Cell.E) {
            int i = 1;
            while (move.getRow() + i < m && move.getCol() + i < n && field[move.getRow() + i][move.getCol() + i] != move.getValue() && field[move.getRow() + i][move.getCol() + i] != Cell.E) {
                i++;
            }
            if (move.getRow() + i < m && move.getCol() + i < n && field[move.getRow() + i][move.getCol() + i] == move.getValue()) {
                return true;
            }
        }

        if (move.getRow() < m - 2 && move.getCol() > 1 && field[move.getRow() + 1][move.getCol() - 1] != move.getValue() && field[move.getRow() + 1][move.getCol() - 1] != Cell.E) {
            int i = 1;
            while (move.getRow() + i < m && move.getCol() - i >= 0 && field[move.getRow() + i][move.getCol() - i] != move.getValue() && field[move.getRow() + i][move.getCol() - i] != Cell.E) {
                i++;
            }
            if (move.getRow() + i < m && move.getCol() - i >= 0 && field[move.getRow() + i][move.getCol() - i] == move.getValue()) {
                return true;
            }
        }

        if (move.getRow() > 1 && field[move.getRow() - 1][move.getCol()] != move.getValue() && field[move.getRow() - 1][move.getCol()] != Cell.E) {
            for (int i = move.getRow() - 1; i >= 0; i--) {
                if (field[i][move.getCol()] == Cell.E) {
                    break;
                }
                if (field[i][move.getCol()] == move.getValue()) {
                    return true;
                }
            }
        }

        if (move.getRow() < m - 2 && field[move.getRow() + 1][move.getCol()] != move.getValue() && field[move.getRow() + 1][move.getCol()] != Cell.E) {
            for (int i = move.getRow() + 1; i < m; i++) {
                if (field[i][move.getCol()] == Cell.E) {
                    break;
                }
                if (field[i][move.getCol()] == move.getValue()) {
                    return true;
                }
            }
        }

        if (move.getCol() > 1 && field[move.getRow()][move.getCol() - 1] != move.getValue() && field[move.getRow()][move.getCol() - 1] != Cell.E) {
            for (int i = move.getCol() - 1; i >= 0; i--) {
                if (field[move.getRow()][i] == Cell.E) {
                    break;
                }
                if (field[move.getRow()][i] == move.getValue()) {
                    return true;
                }
            }
        }

        if (move.getCol() < n - 2  && field[move.getRow()][move.getCol() + 1] != move.getValue() && field[move.getRow()][move.getCol() + 1] != Cell.E) {
            for (int i = move.getCol() + 1; i < n; i++) {
                if (field[move.getRow()][i] == Cell.E) {
                    break;
                }
                if (field[move.getRow()][i] == move.getValue()) {
                    return true;
                }
            }
        }
        return false;
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
