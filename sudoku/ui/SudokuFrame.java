package sudoku.ui;

import sudoku.game.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SudokuFrame extends JFrame {
    public final static int SIZE = 450;
    public SudokuFrame() {
        super("Sudoku");
        setPreferredSize(new Dimension(SudokuFrame.SIZE, SudokuFrame.SIZE));
        setResizable(false);
        setLocationRelativeTo(null);

        int[][] solvedBoard = Sudoku.parseBoardFromFile("sudoku.txt");
        Sudoku sudoku = new Sudoku(solvedBoard);
        add(new SudokuPanel(sudoku));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
