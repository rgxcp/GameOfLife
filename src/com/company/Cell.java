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
    public static boolean hasTopLeftNeighbor(int row, int column) {
        int neighborRow = row - 1;
        int neighborColumn = column - 1;
        return neighborRow >= 0 && neighborColumn >= 0;
    }

    public static boolean hasTopNeighbor(int row) {
        int neighborRow = row - 1;
        return neighborRow >= 0;
    }

    public static boolean hasTopRightNeighbor(int row, int column, int columnCount) {
        int neighborRow = row - 1;
        int neighborColumn = column + 1;
        return neighborRow >= 0 && neighborColumn <= columnCount;
    }

    public static boolean hasLeftNeighbor(int column) {
        int neighborColumn = column - 1;
        return neighborColumn >= 0;
    }

    public static boolean hasRightNeighbor(int column, int columnCount) {
        int neighborColumn = column + 1;
        return neighborColumn <= columnCount;
    }

    public static boolean hasBottomLeftNeighbor(int row, int column, int rowCount) {
        int neighborRow = row + 1;
        int neighborColumn = column - 1;
        return neighborRow <= rowCount && neighborColumn >= 0;
    }

    public static boolean hasBottomNeighbor(int row, int rowCount) {
        int neighborRow = row + 1;
        return neighborRow <= rowCount;
    }

    public static boolean hasBottomRightNeighbor(int row, int column, int rowCount, int columnCount) {
        int neighborRow = row + 1;
        int neighborColumn = column + 1;
        return neighborRow <= rowCount && neighborColumn <= columnCount;
    }

    public static boolean isAlive(int cellNumber) {
        return cellNumber == 1;
    }

    public static int determineCell(int neighborCount, int defaultCellNumber) {
        if (neighborCount == 0 || neighborCount == 1 || neighborCount >= 4) {
            return 0;
        } else if (neighborCount == 3) {
            return 1;
        } else {
            return defaultCellNumber;
        }
    }
}
