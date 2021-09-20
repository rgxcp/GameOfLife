package com.company;

public class Cell {
    // Class Variable (Member)
    int mCell;

    // Constructor
    public Cell(int cell) {
        mCell = cell;
    }

    // Methods
    public void printCell() {
        if (mCell == 0) {
            System.out.print("▒ ");
        } else {
            System.out.print("▓ ");
        }
    }

    // Class Methods
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
}
