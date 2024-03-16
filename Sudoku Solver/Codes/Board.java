package board;

import java.util.List;
import triple.Triple;

public class Board {
    public int size;
    public int matrix[][];

    // constructor
    public Board(int size) {
        this.size = size;
        this.matrix = new int[size][size];
    }

    // For printing the boardd
    public void printBoard() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method-01
    public void setUpBoardConfig(int row, int col, int val) {
        this.matrix[row][col] = val;

    }

    // Method-02
    public void setUpColumnwise(int row, List<Integer> col, List<Integer> val) {
        for (int i = 0; i < col.size(); i++) {
            this.matrix[row][col.get(i)] = val.get(i);
        }
    }

    // Method-03
    public void setUpBoard(List<Triple> triple) {
        for (int i = 0; i < triple.size(); i++) {
            matrix[triple.get(i).row][triple.get(i).col] = triple.get(i).val;
        }
    }

    // We can use any method to setUp the borad
    // Here I use all methods
    // Few rows initialzed with method-01
    // Few rows initialzed with method-02
    // Few rows initialzed with method-03

}
