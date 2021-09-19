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
                boolean cellHasTopLeftNeighbor = true;
                // if current index: row = 0, column = 0
                // top left neighbor index must be: row = -1, column = -1
                if (row - 1 <= grid.length && column - 1 <= grid.length) {
                    cellHasTopLeftNeighbor = false;
                }
                System.out.println("Cell has top left neighbor: " + cellHasTopLeftNeighbor);
            }
            System.out.println();
        }
    }
}
