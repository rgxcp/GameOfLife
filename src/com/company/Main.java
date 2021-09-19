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

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length; column++) {
                System.out.println("Cell: " + grid[row][column]);
                int neighborCount = 0;
                if (cellHasTopLeftNeighbor(row, column) && neighborCellIsAlive(grid[row - 1][column - 1])) {
                    neighborCount++;
                }
                if (cellHasTopNeighbor(row) && neighborCellIsAlive(grid[row - 1][column])) {
                    neighborCount++;
                }
                if (cellHasTopRightNeighbor(row, column, grid.length - 1) && neighborCellIsAlive(grid[row - 1][column + 1])) {
                    neighborCount++;
                }
                if (cellHasLeftNeighbor(column) && neighborCellIsAlive(grid[1][column - 1])) {
                    neighborCount++;
                }
                if (cellHasRightNeighbor(column, grid.length - 1) && neighborCellIsAlive(grid[row][column + 1])) {
                    neighborCount++;
                }
                if (cellHasBottomLeftNeighbor(row, column, grid.length - 1) && neighborCellIsAlive(grid[row + 1][column - 1])) {
                    neighborCount++;
                }
                if (cellHasBottomNeighbor(row, grid.length - 1) && neighborCellIsAlive(grid[row + 1][column])) {
                    neighborCount++;
                }
                if (cellHasBottomRightNeighbor(row, column, grid.length - 1, grid[row].length - 1) && neighborCellIsAlive(grid[row + 1][column + 1])) {
                    neighborCount++;
                }
                System.out.println("Neighbor Count: " + neighborCount);
            }
            System.out.println();
        }
    }

    public static boolean cellHasTopLeftNeighbor(int row, int column) {
        int cellTopLeftNeighborRow = row - 1;
        int cellTopLeftNeighborColumn = column - 1;
        return cellTopLeftNeighborRow >= 0 && cellTopLeftNeighborColumn >= 0;
    }

    public static boolean cellHasTopNeighbor(int row) {
        int cellTopNeighborRow = row - 1;
        return cellTopNeighborRow >= 0;
    }

    public static boolean cellHasTopRightNeighbor(int row, int column, int size) {
        int cellTopRightNeighborRow = row - 1;
        int cellTopRightNeighborColumn = column + 1;
        return (cellTopRightNeighborRow >= 0 && !(cellTopRightNeighborColumn >= size));
    }

    public static boolean cellHasLeftNeighbor(int column) {
        int cellLeftNeighborColumn = column - 1;
        return cellLeftNeighborColumn >= 0;
    }

    public static boolean cellHasRightNeighbor(int column, int size) {
        int cellRightNeighborColumn = column + 1;
        return !(cellRightNeighborColumn >= size);
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
