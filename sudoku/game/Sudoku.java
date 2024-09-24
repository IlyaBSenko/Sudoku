package sudoku.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {

    private final int[][] board;

    public Sudoku(int[][] board) {
        this.board = board;
    }

    public boolean isNumberValid(int row, int column, int number) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == number) {
                return false;
            }
        }
        
        for (int r = 0; r < 9; r++) {
            if (board[r][column] == number) {
                return false;
            }
        }

        // sub grid checker
        int subGridRowStart = (row / 3) * 3;
        int subGridColumnStart = (column / 3) * 3;
        for (int r = subGridRowStart; r < subGridRowStart + 3; r++) {
            for (int col = subGridColumnStart; col < subGridColumnStart + 3; col++) {
                if (board[r][col] == number) {
                    return false;
                }
            }
        }
        return true;

    }

    public void setNumber(int row, int column, int number) {
        this.board[row][column] = number;
    }

    public int getNumber(int row, int column) {
        return this.board[row][column];
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
