package com.company;

public class Neighbor {
    // Class Methods
    public static int countNeighbor(int row, int column, int rowCount, int columnCount, int[][] grid) {
        int count = 0;

        if (Cell.hasTopLeftNeighbor(row, column) && Cell.isAlive(grid[row - 1][column - 1])) {
            count++;
        }
        if (Cell.hasTopNeighbor(row) && Cell.isAlive(grid[row - 1][column])) {
            count++;
        }
        if (Cell.hasTopRightNeighbor(row, column, columnCount) && Cell.isAlive(grid[row - 1][column + 1])) {
            count++;
        }
        if (Cell.hasLeftNeighbor(column) && Cell.isAlive(grid[row][column - 1])) {
            count++;
        }
        if (Cell.hasRightNeighbor(column, columnCount) && Cell.isAlive(grid[row][column + 1])) {
            count++;
        }
        if (Cell.hasBottomLeftNeighbor(row, column, rowCount) && Cell.isAlive(grid[row + 1][column - 1])) {
            count++;
        }
        if (Cell.hasBottomNeighbor(row, rowCount) && Cell.isAlive(grid[row + 1][column])) {
            count++;
        }
        if (Cell.hasBottomRightNeighbor(row, column, rowCount, columnCount) && Cell.isAlive(grid[row + 1][column + 1])) {
            count++;
        }

        return count;
    }
}
