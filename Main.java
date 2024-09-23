public class Main {
    public static void main(String[] args) {
        int[][] solvedBoard = Sudoku.parseBoardFromFile("sudoku.txt");
        int[][] startingBoard = SudokuSolver.findStart(solvedBoard, 81);

        Sudoku sudoku = new Sudoku(solvedBoard);
        sudoku.printBoard();
    }
}
