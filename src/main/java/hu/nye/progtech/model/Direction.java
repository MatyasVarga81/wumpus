package hu.nye.progtech.model;

public enum Direction {
    NORTH, // Észak
    EAST,  // Kelet
    SOUTH, // Dél
    WEST;  // Nyugat

    public static Direction turnRight(Direction current) {
        return switch (current) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public static Direction turnLeft(Direction current) {
        return switch (current) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }
}
