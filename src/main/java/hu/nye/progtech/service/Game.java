package hu.nye.progtech.service;

import hu.nye.progtech.model.Board;
import hu.nye.progtech.model.CellType;
import hu.nye.progtech.model.Direction;
import hu.nye.progtech.model.Hero;

import java.util.Scanner;

public class Game {

    public Game(Board gameLoader) {
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consuming the newline character

            switch (choice) {
                case 1:
                    editBoard ();
                    break;
                case 2:
                    // Implementálni kell a fájlból beolvasást
                    break;
                case 3:
                    // Implementálni kell az adatbázisból betöltést
                    break;
                case 4:
                    // Implementálni kell az adatbázisba mentést
                    break;
                case 5:
                    playGame();
                    break;
                case 6:
                    System.out.println("Exiting the game. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 6);
    }

    private void printMenu() {
        System.out.println("===== Game Menu =====");
        System.out.println("1. Edit Board");
        System.out.println("2. Load from File");
        System.out.println("3. Load from Database");
        System.out.println("4. Save to Database");
        System.out.println("5. Play Game");
        System.out.println("6. Exit");
    }
    private void editBoard() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pályaszerkesztés...");

        System.out.print("Adja meg a pálya méretét (NxN): ");
        int size = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Adja meg a hős oszlopát: ");
        int heroCol = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Adja meg a hős sorát: ");
        int heroRow = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Adja meg a hős irányát (N/W/S/E): ");
        Direction heroDirection = Direction.valueOf(scanner.nextLine().toUpperCase());

        // TODO: Implementáld a további bekéréseket a pálya elemeire

        CellType[][] cells = new CellType[size][size];
        Hero hero = new Hero(heroCol, heroRow, heroDirection, cells);
        Board board = new Board(cells, hero);
    }
    private void playGame() {
        // Implementálni kell a játékmenetet
        System.out.println("Starting the game...");
    }
}
