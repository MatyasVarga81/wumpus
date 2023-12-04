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

    public Board(Scanner fileScanner) {
        this.cells = null;
        this.hero = null;
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileScanner.nextLine())))) {
            // Pálya mérete és kezdeti állapota
            String[] firstLine = br.readLine().split(" ");
            int size = Integer.parseInt(firstLine[0]);
            int heroCol = Integer.parseInt(firstLine[1]);
            int heroRow = Integer.parseInt(firstLine[2]);
            Direction heroDirection = Direction.valueOf(firstLine[3]);

            this.cells = new CellType[size][size];
            this.hero = new Hero(heroCol, heroRow, heroDirection);

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
                switch (cellChar) {
                    case 'W':
                        cells[i][j] = CellType.WALL;
                        break;
                    case 'H':
                        cells[i][j] = CellType.HERO;
                        break;
                    case 'U':
                        cells[i][j] = CellType.WUMPUS;
                        break;
                    case 'P':
                        cells[i][j] = CellType.PIT;
                        break;
                    case 'G':
                        cells[i][j] = CellType.GOLD;
                        break;
                    case '-':
                        cells[i][j] = CellType.EMPTY;
                        break;
                }
            }
        }
    }

  private void placeHeroOnBoard() {

        cells[hero.getCol()][hero.getRow()] = CellType.HERO;
   }

    public void printBoard() {
        // Implementáld a pálya kiírását a konzolra
        // Az itt csak egy példa, a te feladatod megvalósítani a pálya megfelelő kiírását
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }
}
