package com.company;

public class Cell {
    int cell;

    public Cell(int cell) {
        this.cell = cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public void printCell() {
        if (cell == 0) {
            System.out.print("▒ ");
        } else {
            System.out.print("▓ ");
        }
    }
}
