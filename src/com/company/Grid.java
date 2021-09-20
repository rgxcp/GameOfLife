package com.company;

import java.util.concurrent.TimeUnit;

public class Grid {
    // Class Variable (Member)
    int[][] mGrid;

    // Constructor
    public void setGrid(int[][] grid) {
        mGrid = grid;
    }

    public void setInitialShape() {
        mGrid = new int[][]{
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

    public void printGrid() throws InterruptedException {
        for (int[] rows : mGrid) {
            for (int columns : rows) {
                Cell cell = new Cell(columns);
                cell.printCell();
            }
            System.out.println();
        }
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
    }

    public int getRowCount() {
        return mGrid.length - 1;
    }

    public int getColumnCount() {
        return mGrid[0].length - 1;
    }

    public boolean containLivingCell() {
        boolean contain = false;
        for (int[] rows : mGrid) {
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
                int neighborCount = countNeighbor(row, column, getRowCount(), getColumnCount(), mGrid);
                nextShape[row][column] = determineCell(neighborCount, mGrid[row][column]);
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

    public static int countNeighbor(int row, int column, int rowCount, int columnCount, int[][] mGrid) {
        int count = 0;

        if (cellHasTopLeftNeighbor(row, column) && neighborCellIsAlive(mGrid[row - 1][column - 1])) {
            count++;
        }
        if (cellHasTopNeighbor(row) && neighborCellIsAlive(mGrid[row - 1][column])) {
            count++;
        }
        if (cellHasTopRightNeighbor(row, column, columnCount) && neighborCellIsAlive(mGrid[row - 1][column + 1])) {
            count++;
        }
        if (cellHasLeftNeighbor(column) && neighborCellIsAlive(mGrid[row][column - 1])) {
            count++;
        }
        if (cellHasRightNeighbor(column, columnCount) && neighborCellIsAlive(mGrid[row][column + 1])) {
            count++;
        }
        if (cellHasBottomLeftNeighbor(row, column, rowCount) && neighborCellIsAlive(mGrid[row + 1][column - 1])) {
            count++;
        }
        if (cellHasBottomNeighbor(row, rowCount) && neighborCellIsAlive(mGrid[row + 1][column])) {
            count++;
        }
        if (cellHasBottomRightNeighbor(row, column, rowCount, columnCount) && neighborCellIsAlive(mGrid[row + 1][column + 1])) {
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
