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
                if (isCellHasTopLeftNeighbor(row, column) && cellIsAlive(grid[row - 1][column - 1])) {
                    neighborCount++;
                }
                if (isCellHasTopNeighbor(row) && cellIsAlive(grid[row - 1][column])) {
                    neighborCount++;
                }
                if (isCellHasTopRightNeighbor(row, column, grid.length) && cellIsAlive(grid[row - 1][column + 1])) {
                    neighborCount++;
                }
                if (isCellHasLeftNeighbor(column) && cellIsAlive(grid[1][column - 1])) {
                    neighborCount++;
                }
                if (isCellHasRightNeighbor(column, grid.length) && cellIsAlive(grid[row][column + 1])) {
                    neighborCount++;
                }
                if (isCellHasBottomLeftNeighbor(row, column, grid.length) && cellIsAlive(grid[row + 1][column - 1])) {
                    neighborCount++;
                }
                if (isCellHasBottomNeighbor(row, grid.length) && cellIsAlive(grid[row + 1][column])) {
                    neighborCount++;
                }
                if (isCellHasBottomRightNeighbor(row, column, grid.length) && cellIsAlive(grid[row + 1][column + 1])) {
                    neighborCount++;
                }
                System.out.println("Neighbor Count: " + neighborCount);
            }
            System.out.println();
        }
    }

    public static boolean isCellHasTopLeftNeighbor(int row, int column) {
        int cellTopLeftNeighborRow = row - 1;
        int cellTopLeftNeighborColumn = column - 1;
        return cellTopLeftNeighborRow >= 0 && cellTopLeftNeighborColumn >= 0;
    }

    public static boolean isCellHasTopNeighbor(int row) {
        int cellTopNeighborRow = row - 1;
        return cellTopNeighborRow >= 0;
    }

    public static boolean isCellHasTopRightNeighbor(int row, int column, int size) {
        int cellTopRightNeighborRow = row - 1;
        int cellTopRightNeighborColumn = column + 1;
        return (cellTopRightNeighborRow >= 0 && !(cellTopRightNeighborColumn >= size));
    }

    public static boolean isCellHasLeftNeighbor(int column) {
        int cellLeftNeighborColumn = column - 1;
        return cellLeftNeighborColumn >= 0;
    }

    public static boolean isCellHasRightNeighbor(int column, int size) {
        int cellRightNeighborColumn = column + 1;
        return !(cellRightNeighborColumn >= size);
    }

    public static boolean isCellHasBottomLeftNeighbor(int row, int column, int size) {
        int cellBottomLeftNeighborRow = row + 1;
        int cellBottomLeftNeighborColumn = column - 1;
        return (!(cellBottomLeftNeighborRow >= size) && cellBottomLeftNeighborColumn >= 0);
    }

    public static boolean isCellHasBottomNeighbor(int row, int size) {
        int cellBottomNeighborRow = row + 1;
        return !(cellBottomNeighborRow >= size);
    }

    public static boolean isCellHasBottomRightNeighbor(int row, int column, int size) {
        int cellBottomRightNeighborRow = row + 1;
        int cellBottomRightNeighborColumn = column + 1;
        return !(cellBottomRightNeighborRow >= size) && !(cellBottomRightNeighborColumn >= size);
    }

    public static boolean cellIsAlive(int cellNumber) {
        return cellNumber == 1;
    }
}
