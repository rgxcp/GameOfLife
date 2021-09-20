package com.company;

import java.util.concurrent.TimeUnit;

public class Grid {
    int[][] grid;

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void setInitialGrid() {
        this.grid = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    public void printCell(int cell) {
        if (cell == 0) {
            System.out.print("▒ ");
        } else {
            System.out.print("▓ ");
        }
    }

    public void printGrid() throws InterruptedException {
        for (int[] rows : grid) {
            for (int columns : rows) {
                printCell(columns);
            }
            System.out.println();
        }
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
    }

    public int getRowCount() {
        return grid.length - 1;
    }

    public int getColumnCount() {
        return grid[0].length - 1;
    }

    public boolean containLivingCell() {
        boolean contain = false;
        for (int[] rows : grid) {
            if (contain) {
                break;
            }

            for (int columns : rows) {
                if (columns == 1) {
                    contain = true;
                    break;
                }
            }
        }
        return contain;
    }

    public int[][] getNextShape() {
        int[][] nextShape = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        for (int row = 0; row <= getRowCount(); row++) {
            for (int column = 0; column <= getColumnCount(); column++) {
                int neighborCount = countNeighbor(row, column, getRowCount(), getColumnCount(), grid);
                nextShape[row][column] = determineCell(neighborCount, grid[row][column]);
            }
            System.out.println();
        }
        System.out.println();

        return nextShape;
    }

    public static boolean cellHasTopLeftNeighbor(int row, int column) {
        int neighborRow = row - 1;
        int neighborColumn = column - 1;
        return neighborRow >= 0 && neighborColumn >= 0;
    }

    public static boolean cellHasTopNeighbor(int row) {
        int neighborRow = row - 1;
        return neighborRow >= 0;
    }

    public static boolean cellHasTopRightNeighbor(int row, int column, int columnCount) {
        int neighborRow = row - 1;
        int neighborColumn = column + 1;
        return neighborRow >= 0 && neighborColumn <= columnCount;
    }

    public static boolean cellHasLeftNeighbor(int column) {
        int neighborColumn = column - 1;
        return neighborColumn >= 0;
    }

    public static boolean cellHasRightNeighbor(int column, int columnCount) {
        int neighborColumn = column + 1;
        return neighborColumn <= columnCount;
    }

    public static boolean cellHasBottomLeftNeighbor(int row, int column, int rowCount) {
        int neighborRow = row + 1;
        int neighborColumn = column - 1;
        return neighborRow <= rowCount && neighborColumn >= 0;
    }

    public static boolean cellHasBottomNeighbor(int row, int rowCount) {
        int neighborRow = row + 1;
        return neighborRow <= rowCount;
    }

    public static boolean cellHasBottomRightNeighbor(int row, int column, int rowCount, int columnCount) {
        int neighborRow = row + 1;
        int neighborColumn = column + 1;
        return neighborRow <= rowCount && neighborColumn <= columnCount;
    }

    public static boolean neighborCellIsAlive(int cell) {
        return cell == 1;
    }

    public static int countNeighbor(int row, int column, int rowCount, int columnCount, int[][] grid) {
        int count = 0;

        if (cellHasTopLeftNeighbor(row, column) && neighborCellIsAlive(grid[row - 1][column - 1])) {
            count++;
        }
        if (cellHasTopNeighbor(row) && neighborCellIsAlive(grid[row - 1][column])) {
            count++;
        }
        if (cellHasTopRightNeighbor(row, column, columnCount) && neighborCellIsAlive(grid[row - 1][column + 1])) {
            count++;
        }
        if (cellHasLeftNeighbor(column) && neighborCellIsAlive(grid[row][column - 1])) {
            count++;
        }
        if (cellHasRightNeighbor(column, columnCount) && neighborCellIsAlive(grid[row][column + 1])) {
            count++;
        }
        if (cellHasBottomLeftNeighbor(row, column, rowCount) && neighborCellIsAlive(grid[row + 1][column - 1])) {
            count++;
        }
        if (cellHasBottomNeighbor(row, rowCount) && neighborCellIsAlive(grid[row + 1][column])) {
            count++;
        }
        if (cellHasBottomRightNeighbor(row, column, rowCount, columnCount) && neighborCellIsAlive(grid[row + 1][column + 1])) {
            count++;
        }

        return count;
    }

    public static int determineCell(int neighborCount, int defaultCell) {
        if (neighborCount == 0 || neighborCount == 1 || neighborCount >= 4) {
            return 0;
        } else if (neighborCount == 3) {
            return 1;
        } else {
            return defaultCell;
        }
    }
}
