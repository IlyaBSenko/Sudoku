public class Sudoku {
    private int[][] board;

    public Sudoku() {
        this.board = new int[9][9];
    }

    public void addStartingNumbers() {
        
    }

    public boolean isNumberValid(int row, int colomn, int number) {
        return false;
    }

    public void setNumber(int row, int colomn, int number) {
        this.board[row][colomn] = number;
    }

    
}
