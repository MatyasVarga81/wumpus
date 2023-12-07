package hu.nye.progtech.service;

import hu.nye.progtech.model.Board;
import hu.nye.progtech.model.CellType;
import hu.nye.progtech.model.Direction;
import hu.nye.progtech.model.Hero;


import java.util.Scanner;


public class Game {
    private Board board;

    public Game(Board gameLoader) {
        this.board = gameLoader;
    }
    private void loadFromFile() {
        board.printBoard();


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
                    editBoard();
                    break;
                case 2:
                    loadFromFile();
                    break;
                case 3:
                    // Implement load from database
                    break;
                case 4:
                    // Implement save to database
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
        int col = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Adja meg a hős sorát: ");
        int row = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Adja meg a hős irányát (NORTH/WEST/SOUTH/EAST): ");
        Direction direction = Direction.valueOf(scanner.nextLine().toUpperCase());

        // TODO: Implementáld a további bekéréseket a pálya elemeire

        CellType[][] cells = new CellType[size][size];
        this.hero = new Hero(col, row, direction);
        this.board = new Board(cells, this.hero);
    }


    private Hero hero; // Declare the hero at the class level

    private void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.printBoard();

            System.out.println("Choose an action:");
            System.out.println("1. Move");
            System.out.println("2. Shoot");
            System.out.println("3. Pickup Gold");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    hero.move();
                    break;
                case 2:
                    hero.shoot();
                    break;
                case 3:
                    hero.pickupGold();
                    break;
                case 4:
                    System.out.println("Quitting the game. Goodbye!");
                    return; // Exit the method and end the game loop
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    continue; // Skip the rest of the loop and start a new iteration
            }

            // Additional game logic based on the current state of the board, hero, etc.

            // Check if the hero reached the exit, defeated the Wumpus, etc.
            // Update the game state accordingly

            // Optionally, add a win/lose condition and break out of the loop
            // based on your game's logic.
        }
    }
}
