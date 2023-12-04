package hu.nye.progtech.service;

import hu.nye.progtech.model.Board;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WumpusGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     //   System.out.print("Kérlek, add meg a fájl nevét: ");
     //   String fileName = scanner.nextLine();

        // Fájlból beolvasás
        try {
            Scanner fileScanner = new Scanner(new File("C:\\Users\\varga\\progTech\\wumpusAI\\src\\main\\resources\\wumpusinput"));

            Object CellType = null;
            Object Hero = null;
            Board board = new Board(fileScanner);

            // Pálya kiírása a konzolra
            board.printBoard();

            // Játék inicializálása
            hu.nye.progtech.service.Game game = new hu.nye.progtech.service.Game(board);

            // Játék elindítása
            game.play();

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hiba a fájl olvasása közben: " + e.getMessage());
        }
    }
}
