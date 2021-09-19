package com.company;

import java.util.concurrent.TimeUnit;

public class Grid {
    int[][] grid;

    public Grid(int[][] grid) {
        this.grid = grid;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void printCell(int cell) {
        if (cell == 0) {
            System.out.print("▒ ");
        } else {
            System.out.print("▓ ");
        }
    }

    public void printGrid() throws InterruptedException {
        for (int[] rows : grid) {
            for (int columns : rows) {
                printCell(columns);
            }
            System.out.println();
        }
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
    }

    public int getRowCount() {
        return grid.length - 1;
    }

    public int getColumnCount() {
        return grid[0].length - 1;
    }

    public boolean containLivingCell() {
        boolean contain = false;
        for (int[] rows : grid) {
            if (contain) {
                break;
            }

            for (int columns : rows) {
                if (columns == 1) {
                    contain = true;
                    break;
                }
            }
        }
        return contain;
    }
}
