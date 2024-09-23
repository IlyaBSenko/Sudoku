import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {

    private final int[][] board;

    public Sudoku(int[][] board) {
        this.board = board;
    }

    public boolean isNumberValid(int row, int column, int number) {
        return false;
    }

    public void setNumber(int row, int column, int number) {
        this.board[row][column] = number;
    }

    public void printBoard() {
        for (int[] row : this.board) {
            for (int column : row) {
                System.out.print(String.valueOf(column) + ' ');
            }
            System.out.print('\n');
        }
    }

    public static int[][] parseBoardFromFile(String path) {
        int[][] board = new int[9][9];

        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            int row = 0;
            int column = 0;
            while (scanner.hasNextLine()) {
                String[] gridRow = scanner.nextLine().split(" ");
                for (String number : gridRow) {
                    board[row][column] = Integer.parseInt(number);
                    column++;
                }
                column = 0;
                row++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file");
            e.printStackTrace();
        }
        return board;
    }
}
