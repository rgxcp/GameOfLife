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
                int neighborCount = Neighbor.countNeighbor(row, column, getRowCount(), getColumnCount(), mGrid);
                nextShape[row][column] = Cell.determineCell(neighborCount, mGrid[row][column]);
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
}
