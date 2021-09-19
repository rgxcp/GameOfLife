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

                boolean cellHasTopRightNeighbor = false;
                int cellTopRightNeighborRow = row - 1;
                int cellTopRightNeighborColumn = column + 1;
                if (cellTopRightNeighborRow >= 0 && !(cellTopRightNeighborColumn >= grid[column].length)) {
                    cellHasTopRightNeighbor = true;
                }
                System.out.println("Cell has top right neighbor: " + cellHasTopRightNeighbor);

                boolean cellHasLeftNeighbor = false;
                int cellLeftNeighborColumn = column - 1;
                if (cellLeftNeighborColumn >= 0) {
                    cellHasLeftNeighbor = true;
                }
                System.out.println("Cell has left neighbor: " + cellHasLeftNeighbor);

                boolean cellHasRightNeighbor = false;
                int cellRightNeighborColumn = column + 1;
                if (!(cellRightNeighborColumn >= grid[column].length)) {
                    cellHasRightNeighbor = true;
                }
                System.out.println("Cell has right neighbor: " + cellHasRightNeighbor);

                boolean cellHasBottomLeftNeighbor = false;
                int cellBottomLeftNeighborRow = row + 1;
                int cellBottomLeftNeighborColumn = column - 1;
                if (!(cellBottomLeftNeighborRow >= grid.length) && cellBottomLeftNeighborColumn >= 0) {
                    cellHasBottomLeftNeighbor = true;
                }
                System.out.println("Cell has bottom left neighbor: " + cellHasBottomLeftNeighbor);

                boolean cellHasBottomNeighbor = false;
                int cellBottomNeighborRow = row + 1;
                if (!(cellBottomNeighborRow >= grid.length)) {
                    cellHasBottomNeighbor = true;
                }
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
}
