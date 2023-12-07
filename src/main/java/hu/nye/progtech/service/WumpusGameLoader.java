package hu.nye.progtech.service;

import hu.nye.progtech.model.Direction;
import hu.nye.progtech.model.Hero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WumpusGameLoader {
    private char[][] board;
    public Hero hero;

    public WumpusGameLoader(String fileName) {
        loadGame(fileName);
    }

    public char[][] getBoard() {
        return board;
    }

    public Hero getHero() {
        return hero;
    }

    private void loadGame(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            // Pálya mérete és kezdeti állapota
            String[] firstLine = br.readLine().split(" ");
            int size = Integer.parseInt(firstLine[0]);
            int heroCol = Integer.parseInt(firstLine[1]);
            int heroRow = Integer.parseInt(firstLine[2]);
            Direction heroDirection = Direction.valueOf(firstLine[3]);

            this.board = new char[size][size];
        //    this.hero = new Hero(col, row, direction);

            // Pálya inicializálása
            initializeBoard(br, size);

            // Hős elhelyezése a pályán
            placeHeroOnBoard();
        } catch (IOException e) {
            System.out.println("Hiba a fájl olvasása közben: " + e.getMessage());
        }
    }

    private void initializeBoard(BufferedReader br, int size) throws IOException {
        for (int i = 0; i < size; i++) {
            String rowString = br.readLine();
            for (int j = 0; j < size; j++) {
                char cellChar = rowString.charAt(j);
                board[i][j] = cellChar;
            }
        }
    }

    private void placeHeroOnBoard() {
        // Helyezd el a hőst a pályán a fájlból beolvasott pozíció alapján
        board[hero.getCol()][hero.getRow()] = 'H';
    }
}
