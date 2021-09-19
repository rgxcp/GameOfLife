package com.company;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] initialGrid = {
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
        };

        Grid grid = new Grid(initialGrid);
        grid.printGrid();

        while (grid.containLivingCell()) {
            int[][] resultGrid = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
            };

            for (int row = 0; row <= grid.getRowCount(); row++) {
                for (int column = 0; column <= grid.getColumnCount(); column++) {
                    int neighborCount = countNeighbor(row, column, grid.getRowCount(), grid.getColumnCount(), grid.getGrid());
                    resultGrid[row][column] = determineCell(neighborCount, grid.getGrid()[row][column]);
                    grid.printCell(resultGrid[row][column]);
                }
                System.out.println();
            }
            System.out.println();
            grid.setGrid(resultGrid);

            TimeUnit.SECONDS.sleep(1);
        }
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
