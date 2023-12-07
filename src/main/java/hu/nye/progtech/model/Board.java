package hu.nye.progtech.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Board {
    private CellType[][] cells;
    private Hero hero;

    public Board(CellType[][] cells, Hero hero) {
        this.cells = cells;
        this.hero = hero;
    }



    public Board(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            // Pálya mérete és kezdeti állapota
            String[] firstLine = br.readLine().split(" ");
            int size = Integer.parseInt(firstLine[0]);
            int col = Integer.parseInt(firstLine[1]);
            int row = Integer.parseInt(firstLine[2]);
            Direction direction = Direction.valueOf(firstLine[3].trim().toUpperCase());

            this.cells = new CellType[size][size];
            this.hero = new Hero(col, row, direction);

            // Pálya inicializálása
            initializeBoard(br, size);

            // Hős elhelyezése a pályán
            placeHeroOnBoard();
        } catch (IOException e) {
            System.out.println("Hiba a fájl olvasása közben: " + e.getMessage());
        }
    }

    // public Board(Scanner fileScanner, Object o, Object hero) {
    // }

    private void initializeBoard(BufferedReader br, int size) throws IOException {
        for (int i = 0; i < size; i++) {
            String rowString = br.readLine();
            for (int j = 0; j < size; j++) {
                char cellChar = rowString.charAt(j);
                CellType cellType;

                switch (cellChar) {
                    case 'W':
                        cellType = CellType.WALL;
                        break;
                    case 'H':
                        cellType = CellType.HERO;
                        break;
                    case 'U':
                        cellType = CellType.WUMPUS;
                        break;
                    case 'P':
                        cellType = CellType.PIT;
                        break;
                    case 'G':
                        cellType = CellType.GOLD;
                        break;
                    case '-':
                        cellType = CellType.EMPTY;
                        break;
                    default:
                        cellType = CellType.EMPTY; // Alapértelmezett érték, ha nem ismerjük fel a karaktert
                        break;
                }

                cells[i][j] = cellType;
            }
        }
    }



    private void placeHeroOnBoard() {

        cells[hero.getCol()][hero.getRow()] = CellType.HERO;
    }

    public void printBoard() {
        // Pálya megjelenítése a konzolon
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                char cellSymbol = getCellSymbol(cells[i][j]);
                System.out.print(cellSymbol + " ");
            }
            System.out.println();
        }
    }

    private char getCellSymbol(CellType cellType) {
        // Az egyes cellatípusokhoz tartozó karakterek visszaadása
        switch (cellType) {
            case WALL:
                return 'W';
            case HERO:
                return 'H';
            case WUMPUS:
                return 'U';
            case PIT:
                return 'P';
            case GOLD:
                return 'G';
            case EMPTY:
                return '-';
            default:
                return '?'; // Ismeretlen cellatípus esetén '?' karaktert használjunk
        }
    }


    public Object getHero() {

        return null;
    }
}

