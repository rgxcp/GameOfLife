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
}
