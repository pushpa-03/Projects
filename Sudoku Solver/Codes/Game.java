package game;

import board.Board;
import player.Player;

public class Game {

    Board board;
    Player player;

    public Game(Board board, Player player) {
        this.board = board;
        this.player = player;
    }

    // Solve the Sudoku game
    public void play() {
        solveSudoku(0, 0);
    }

    // This function based on backTracking
    public void solveSudoku(int row, int col) {
        if (row == board.size) {
            System.out.println("\n");
            System.out.println("Sudoku solved!!!!!");
            board.printBoard();
            return;
        }
        int nrow = 0, ncol = 0;

        if (col == board.size - 1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if (board.matrix[row][col] != 0) {
            solveSudoku(nrow, ncol);
        } else {
            for (int i = 0; i <= 9; i++) {
                if (validPos(board.matrix, row, col, i) == true) {
                    board.matrix[row][col] = i;
                    solveSudoku(nrow, ncol);
                    board.matrix[row][col] = 0;
                }
            }
        }
    }

    // Checking as per the game rules
    private boolean validPos(int matrix[][], int row, int col, int val) {

        // Checking valid position in row
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == val) {
                return false;
            }
        }

        // Checking valid position in col
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == val) {
                return false;
            }
        }

        // Checking valid position in 3 * 3 box or grid
        // it formula for checking
        int tempRow = row / 3 * 3;
        int tempCol = col / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[tempRow + i][tempCol + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

}
