package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGame extends JFrame {
    private static final int GRID_SIZE = 9;
    private static final int CELL_SIZE = 60;
    private static final int BOARD_SIZE = GRID_SIZE * CELL_SIZE;

    private JTextField[][] grid;

    public SudokuGame() {
        grid = new JTextField[GRID_SIZE][GRID_SIZE];

        setTitle("Sudoku Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(BOARD_SIZE, BOARD_SIZE);

        JPanel panel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        panel.setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Font font = new Font("SansSerif", Font.BOLD, 20);

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                grid[row][col] = new JTextField();
                grid[row][col].setFont(font);
                grid[row][col].setHorizontalAlignment(JTextField.CENTER);
                panel.add(grid[row][col]);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solveSudoku();
            }
        });

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.CENTER);
        container.add(solveButton, BorderLayout.SOUTH);
    }

    private boolean solveSudoku() {
        int[][] board = new int[GRID_SIZE][GRID_SIZE];

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                String value = grid[row][col].getText();
                if (value.isEmpty()) {
                    board[row][col] = 0;
                } else {
                    try {
                        int number = Integer.parseInt(value);
                        board[row][col] = number;
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid input at row " + (row + 1) + ", column " + (col + 1));
                        return false;
                    }
                }
            }
        }

        SudokuSolver solver = new SudokuSolver(board);
        if (solver.solve()) {
            int[][] solution = solver.getSolution();
            for (int row = 0; row < GRID_SIZE; row++) {
                for (int col = 0; col < GRID_SIZE; col++) {
                    grid[row][col].setText(Integer.toString(solution[row][col]));
                }
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "No solution exists for the given Sudoku puzzle.");
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SudokuGame().setVisible(true);
            }
        });
    }
}



