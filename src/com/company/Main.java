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

        int rowCount = grid.length - 1;
        int columnCount = grid[0].length - 1;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length; column++) {
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

                String status = "Stays";
                if (neighborCount == 0 || neighborCount == 1) {
                    status = "Died";
                }

                if (neighborCount >= 4) {
                    status = "Died";
                }

                if (neighborCount == 3) {
                    status = "Alive";
                }

                System.out.print(neighborCount + "(" + status + ")" + " ");
            }
            System.out.println();
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
