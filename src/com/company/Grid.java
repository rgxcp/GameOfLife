package com.company;

import java.util.concurrent.TimeUnit;

public class Grid {
    // Class Variable (Member)
    int[][] mGrid;

    // Setter
    public void setGrid(int[][] grid) {
        mGrid = grid;
    }

    // Methods
    public int getRowCount() {
        return mGrid.length - 1;
    }

    public int getColumnCount() {
        return mGrid[0].length - 1;
    }

    // FIX
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
            for (int cellNumber : rows) {
                Cell cell = new Cell(cellNumber);
                cell.printCell();
            }
            System.out.println();
        }
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
    }

    public boolean containLivingCell() {
        boolean contain = false;
        for (int[] rows : mGrid) {
            if (contain) {
                break;
            }

            for (int cellNumber : rows) {
                if (cellNumber == 1) {
                    contain = true;
                    break;
                }
            }
        }
        return contain;
    }

    public static boolean neighborCellIsAlive(int cell) {
        return cell == 1;
    }

    public static int countNeighbor(int row, int column, int rowCount, int columnCount, int[][] mGrid) {
        int count = 0;

        if (Cell.cellHasTopLeftNeighbor(row, column) && neighborCellIsAlive(mGrid[row - 1][column - 1])) {
            count++;
        }
        if (Cell.cellHasTopNeighbor(row) && neighborCellIsAlive(mGrid[row - 1][column])) {
            count++;
        }
        if (Cell.cellHasTopRightNeighbor(row, column, columnCount) && neighborCellIsAlive(mGrid[row - 1][column + 1])) {
            count++;
        }
        if (Cell.cellHasLeftNeighbor(column) && neighborCellIsAlive(mGrid[row][column - 1])) {
            count++;
        }
        if (Cell.cellHasRightNeighbor(column, columnCount) && neighborCellIsAlive(mGrid[row][column + 1])) {
            count++;
        }
        if (Cell.cellHasBottomLeftNeighbor(row, column, rowCount) && neighborCellIsAlive(mGrid[row + 1][column - 1])) {
            count++;
        }
        if (Cell.cellHasBottomNeighbor(row, rowCount) && neighborCellIsAlive(mGrid[row + 1][column])) {
            count++;
        }
        if (Cell.cellHasBottomRightNeighbor(row, column, rowCount, columnCount) && neighborCellIsAlive(mGrid[row + 1][column + 1])) {
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
