import java.util.Random;

public class SudokuSolver {
    
    public static final int STARTING_HINTS = 30;


    public static int[][] solveBoard(int[][] board) {
        return null;
    }

    public static int[][] findStart(int[][] board, int totalTiles) {
        if (totalTiles == STARTING_HINTS) {
            return board;
        }
    
        Random random = new Random();
        int row = random.nextInt(10);
        int column = random.nextInt(10);
         

        return null;
    }
}
