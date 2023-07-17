package com.game;

class SudokuSolver {
    private static final int GRID_SIZE = 9;
    private static final int SUBGRID_SIZE = 3;
    private static final int BOARD_SIZE = GRID_SIZE * GRID_SIZE;

    private int[][] board;

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    public boolean solve() {
        int row = 0;
        int col = 0;
        boolean isEmpty = true;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int number = 1; number <= GRID_SIZE; number++) {
            if (isValid(row, col, number)) {
                board[row][col] = number;

                if (solve()) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, int number) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number || board[i][col] == number) {
                return false;
            }
        }

        int subgridRow = row - row % SUBGRID_SIZE;
        int subgridCol = col - col % SUBGRID_SIZE;

        for (int i = 0; i < SUBGRID_SIZE; i++) {
            for (int j = 0; j < SUBGRID_SIZE; j++) {
                if (board[subgridRow + i][subgridCol + j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    public int[][] getSolution() {
        return board;
    }
}
