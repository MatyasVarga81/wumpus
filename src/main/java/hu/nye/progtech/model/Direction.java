package hu.nye.progtech.model;

public enum Direction {
    NORTH, // Észak
    EAST,  // Kelet
    SOUTH, // Dél
    WEST, Direction;  // Nyugat

    public static Direction turnRight(Direction current) {
        return switch(current) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            default -> throw new IllegalStateException("Unexpected value: " + current);
        };
    }

    public static Direction turnLeft(Direction current) {
        return switch(current) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            default -> throw new IllegalStateException("Unexpected value: " + current);
        };
    }
}
