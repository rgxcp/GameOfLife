package com.company;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid.length; column++) {
                System.out.println(grid[row][column]);

                boolean cellHasTopLeftNeighbor = isCellHasTopLeftNeighbor(row, column);
                System.out.println("Cell has top left neighbor: " + cellHasTopLeftNeighbor);

                boolean cellHasTopNeighbor = isCellHasTopNeighbor(row);
                System.out.println("Cell has top neighbor: " + cellHasTopNeighbor);

                boolean cellHasTopRightNeighbor = isCellHasTopRightNeighbor(row, column, grid[column].length);
                System.out.println("Cell has top right neighbor: " + cellHasTopRightNeighbor);

                boolean cellHasLeftNeighbor = isCellHasLeftNeighbor(column);
                System.out.println("Cell has left neighbor: " + cellHasLeftNeighbor);

                boolean cellHasRightNeighbor = isCellHasRightNeighbor(column, grid[column].length);
                System.out.println("Cell has right neighbor: " + cellHasRightNeighbor);

                boolean cellHasBottomLeftNeighbor = isCellHasBottomLeftNeighbor(row, column, grid.length);
                System.out.println("Cell has bottom left neighbor: " + cellHasBottomLeftNeighbor);

                boolean cellHasBottomNeighbor = isCellHasBottomNeighbor(row, grid.length);
                System.out.println("Cell has bottom neighbor: " + cellHasBottomNeighbor);

                boolean cellHasBottomRightNeighbor = false;
                int cellBottomRightNeighborRow = row + 1;
                int cellBottomRightNeighborColumn = column + 1;
                if (!(cellBottomRightNeighborRow >= grid.length) && !(cellBottomRightNeighborColumn >= grid.length)) {
                    cellHasBottomRightNeighbor = true;
                }
                System.out.println("Cell has bottom right neighbor: " + cellHasBottomRightNeighbor);
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
}
