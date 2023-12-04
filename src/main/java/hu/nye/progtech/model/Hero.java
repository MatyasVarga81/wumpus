package hu.nye.progtech.model;

public class Hero {
    private int row;
    private int col;
    private Direction direction;
    private int arrows;


        private CellType[][] board;

        public Hero(int row, int col, Direction direction, int arrows, CellType[][] board) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.arrows = arrows;
            this.board = board;
        }

        public Hero(int heroCol, int heroRow, Direction heroDirection, CellType[][] board) {
            this.col = heroCol;
            this.row = heroRow;
            this.direction = heroDirection;
            this.board = board;
        }

    public Hero(int heroCol, int heroRow, Direction heroDirection) {
    }

    public Hero(int heroCol, int heroRow, Direction heroDirection, char[][] board) {
    }


    public void move() {
        switch (direction) {
            case NORTH -> {
                if (row > 0 && board[row - 1][col] != CellType.WALL) {
                    row--;
                }
            }
            case EAST -> {
                if (col < board[0].length - 1 && board[row][col + 1] != CellType.WALL) {
                    col++;
                }
            }
            case SOUTH -> {
                if (row < board.length - 1 && board[row + 1][col] != CellType.WALL) {
                    row++;
                }
            }
            case WEST -> {
                if (col > 0 && board[row][col - 1] != CellType.WALL) {
                    col--;
                }
            }
        }
    }

    public void shoot() {
        if (arrows > 0) {
            arrows--;

            int arrowRow = row;
            int arrowCol = col;

            switch (direction) {
                case NORTH -> {
                    while (arrowRow > 0 && board[arrowRow][arrowCol] != CellType.WALL) {
                        arrowRow--;
                        if (board[arrowRow][arrowCol] == CellType.WUMPUS) {
                            // Wumpus találat
                            board[arrowRow][arrowCol] = CellType.EMPTY;
                            System.out.println("Sikeres lövés! Wumpus eltalálva!");
                            break;
                        }
                    }
                }
                case EAST -> {
                    if (col < board[0].length - 1 && board[row][col + 1] != CellType.WALL) {
                        col++;
                    }
                }
                case SOUTH -> {
                    if (row < board.length - 1 && board[row + 1][col] != CellType.WALL) {
                        row++;
                    }
                }
                case WEST -> {
                    if (col > 0 && board[row][col - 1] != CellType.WALL) {
                        col--;
                    }
                }
            }
        } else {
            System.out.println("Nincs több nyilad!");
        }
    }

    public void pickupGold() {
        if (board[row][col] == CellType.GOLD) {
            // Arany felszedése
            board[row][col] = CellType.EMPTY;
            System.out.println("Arany felszedve!");
        } else {
            System.out.println("Itt nincs arany!");
        }
    }


    public int getCol() {
    return col;
        }

    public int getRow() {
    return row;
        }
}