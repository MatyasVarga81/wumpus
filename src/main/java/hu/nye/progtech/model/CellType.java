package hu.nye.progtech.model;

public enum CellType {
    EMPTY('-'),
    WALL('W'),
    HERO('H'),
    WUMPUS('U'),
    PIT('P'),
    GOLD('G');

    private char symbol;

    CellType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}