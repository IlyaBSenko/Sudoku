public class Main {
    public static void main(String[] args) {
        int[][] solvedBoard = Sudoku.parseBoardFromFile("sudoku.txt");
        int[][] startingBoard = SudokuSolver.findStart(solvedBoard);

        Sudoku sudoku = new Sudoku(solvedBoard);
        sudoku.printBoard();
    }
}
