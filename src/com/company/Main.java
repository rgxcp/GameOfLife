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

                boolean cellHasTopLeftNeighbor = false;
                int cellTopLeftNeighborRow = row - 1;
                int cellTopLeftNeighborColumn = column - 1;
                if (cellTopLeftNeighborRow >= 0 && cellTopLeftNeighborColumn >= 0) {
                    cellHasTopLeftNeighbor = true;
                }
                System.out.println("Cell has top left neighbor: " + cellHasTopLeftNeighbor);

                boolean cellHasTopNeighbor = false;
                int cellTopNeighborRow = row - 1;
                if (cellTopNeighborRow >= 0) {
                    cellHasTopNeighbor = true;
                }
                System.out.println("Cell has top neighbor: " + cellHasTopNeighbor);

                boolean cellHasTopRightNeighbor = false;
                int cellTopRightNeighborRow = row - 1;
                int cellTopRightNeighborColumn = column + 1;
                if (cellTopRightNeighborRow >= 0 && !(cellTopRightNeighborColumn >= grid[column].length - 1)) {
                    cellHasTopRightNeighbor = true;
                }
                System.out.println("Cell has top right neighbor: " + cellHasTopRightNeighbor);
            }
            System.out.println();
        }
    }
}
