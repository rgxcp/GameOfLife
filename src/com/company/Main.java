package com.company;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Grid grid = new Grid();
        grid.setInitialGrid();
        grid.printGrid();

        while (grid.containLivingCell()) {
            int[][] nextShape = grid.getNextShape();
            grid.setGrid(nextShape);
            grid.printGrid();
        }
    }
}
