package sudoku.ui;

import sudoku.game.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SudokuPanel extends JPanel {

    private Sudoku sudoku;

    public SudokuPanel(Sudoku sudoku) {
        this.sudoku = sudoku;
        setPreferredSize(new Dimension(450, 450));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick(e.getPoint());
            }
        });

        sudoku.printBoard();
    }

    public void handleClick(Point point) {
        int cellWidth = SudokuFrame.SIZE / 9;
        int gridRow = ((point.y) / cellWidth) % 9;
        int gridColumn = (point.x / cellWidth) % 9;
        System.out.println(this.sudoku.getNumber(gridRow, gridColumn));
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        drawGrid(g);
        drawNumbers(g);
    }

    public void drawGrid(Graphics g) {
        int cellWidth = SudokuFrame.SIZE / 9;

        g.setColor(Color.BLACK);
        for (int i = 0; i < 9; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, SudokuFrame.SIZE);
        }

        for (int j = 0; j < 9; j++) {
            g.drawLine(0, j * cellWidth, SudokuFrame.SIZE, j * cellWidth);
        }
    }

    public void drawNumbers(Graphics g) {
        int cellWidth = SudokuFrame.SIZE / 9;

        int centerOffset = cellWidth / 2;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int x = j * cellWidth + centerOffset;
                int y = i * cellWidth + centerOffset;
                int number = this.sudoku.getNumber(i, j);
                g.drawString(Integer.toString(number), x, y);
            }
        }
    }
}
