package board;

//Create Board class
public class Board {
    public int size;
    public char matrix[][];

    // Constructor
    public Board(int size, char defaultSymbol) {
        this.size = size;
        matrix = new char[size][size];

        // initilising matrix with default value
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = defaultSymbol;
            }
        }
    }

    public void setDefaultSymbol(char symbol) { // Another way to initialise with default symbol and I do not use in
                                                // this project
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = symbol;
            }
        }
    }

    // Board display
    public void printBoardConfig() {
        int sz = this.size;

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
