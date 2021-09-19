package com.company;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0}
        };

        int[][] resultGrid = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        int rowCount = grid.length - 1;
        int columnCount = grid[0].length - 1;

        for (int i = 0; i < 3; i++) {
            for (int row = 0; row <= rowCount; row++) {
                for (int column = 0; column <= columnCount; column++) {
                    int neighborCount = 0;
                    if (cellHasTopLeftNeighbor(row, column) && neighborCellIsAlive(grid[row - 1][column - 1])) {
                        neighborCount++;
                    }
                    if (cellHasTopNeighbor(row) && neighborCellIsAlive(grid[row - 1][column])) {
                        neighborCount++;
                    }
                    if (cellHasTopRightNeighbor(row, column, columnCount) && neighborCellIsAlive(grid[row - 1][column + 1])) {
                        neighborCount++;
                    }
                    if (cellHasLeftNeighbor(column) && neighborCellIsAlive(grid[row][column - 1])) {
                        neighborCount++;
                    }
                    if (cellHasRightNeighbor(column, columnCount) && neighborCellIsAlive(grid[row][column + 1])) {
                        neighborCount++;
                    }
                    if (cellHasBottomLeftNeighbor(row, column, rowCount) && neighborCellIsAlive(grid[row + 1][column - 1])) {
                        neighborCount++;
                    }
                    if (cellHasBottomNeighbor(row, rowCount) && neighborCellIsAlive(grid[row + 1][column])) {
                        neighborCount++;
                    }
                    if (cellHasBottomRightNeighbor(row, column, rowCount, columnCount) && neighborCellIsAlive(grid[row + 1][column + 1])) {
                        neighborCount++;
                    }

                    if (neighborCount == 0 || neighborCount == 1 || neighborCount >= 4) {
                        resultGrid[row][column] = 0;
                    } else if (neighborCount == 3) {
                        resultGrid[row][column] = 1;
                    } else {
                        resultGrid[row][column] = grid[row][column];
                    }

                    if (resultGrid[row][column] == 0) {
                        System.out.print("-");
                    } else {
                        System.out.print("+");
                    }
                }
                System.out.println("");
            }
            System.out.println("");
            grid = resultGrid;
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
}
