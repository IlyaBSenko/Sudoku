package sudoku;

import sudoku.game.*;
import sudoku.ui.SudokuFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SudokuFrame::new);
    }
}
