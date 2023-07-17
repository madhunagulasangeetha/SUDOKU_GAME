# SUDOKU_GAME

This Sudoku game project implemented in Java using the Swing library allows users to play Sudoku interactively. It provides a graphical user interface (GUI) where users can click on the cells and enter numbers to solve the Sudoku puzzle. The game initializes with a predefined puzzle, and the user can attempt to solve it manually or click the "Solve" button to automatically solve the Sudoku using a backtracking algorithm.

The Sudoku game GUI is built using a 9x9 grid of text fields, where the user can enter numbers. Initially, the puzzle's predefined numbers are displayed in the corresponding cells, and the user cannot modify them. The remaining empty cells can be filled with numbers from 1 to 9, following the Sudoku rules.

When the user clicks the "Solve" button, the program attempts to solve the Sudoku puzzle using a recursive backtracking algorithm. If a solution is found, the solved Sudoku is displayed in the GUI, and the user cannot modify it anymore. If no solution is found, a message dialog informs the user that the Sudoku is unsolvable.

This project demonstrates the usage of Java and Swing to create a simple yet engaging Sudoku game, providing an enjoyable user experience for playing and solving Sudoku puzzles.
