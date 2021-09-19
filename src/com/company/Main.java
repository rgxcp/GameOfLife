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
                // if current index: row = 0, column = 0
                // top left neighbor index must be: row = -1, column = -1
                int topLeftNeighborRow = row - 1;
                int topLeftNeighborColumn = column - 1;
                if (topLeftNeighborRow >= 0 && topLeftNeighborColumn >= 0) {
                    cellHasTopLeftNeighbor = true;
                }
                System.out.println("Cell has top left neighbor: " + cellHasTopLeftNeighbor);
            }
            System.out.println();
        }
    }
}
