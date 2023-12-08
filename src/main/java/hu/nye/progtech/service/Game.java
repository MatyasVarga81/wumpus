package hu.nye.progtech.service;

import hu.nye.progtech.model.Board;
import hu.nye.progtech.model.CellType;
import hu.nye.progtech.model.Direction;
import hu.nye.progtech.model.Hero;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static hu.nye.progtech.model.Direction.*;

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
            scanner.nextLine();

            switch (choice) {
                case 1:
                    editBoard();
                    break;
                case 2:
                    loadFromFile();
                    break;
                case 3:
                    loadFromDatabase();
                    break;
                case 4:
                    savetoDatabase();
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

    private void savetoDatabase() {
        try (Connection connection = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO game_state (col, row, direction) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, hero.getCol());
                statement.setInt(2, hero.getRow());
                statement.setString(3, hero.getDirection().toString());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }}

    private void loadFromDatabase() {
        try (Connection connection = DriverManager.getConnection(url)) {
        String sql = "SELECT * FROM game_state ORDER BY id DESC LIMIT 1";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int col = resultSet.getInt("col");
                int row = resultSet.getInt("row");
                Direction direction = Direction.valueOf(resultSet.getString("direction"));

                hero = new Hero(col, row, direction);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    private final String url = "jdbc:sqlite:game_database.db";


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
        scanner.nextLine();

        System.out.print("Adja meg a hős oszlopát: ");
        int col = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Adja meg a hős sorát: ");
        int row = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Adja meg a hős irányát (NORTH/WEST/SOUTH/EAST): ");
        Direction direction = Direction.valueOf(scanner.nextLine().toUpperCase());

                CellType[][] cells = new CellType[size][size];
        this.hero = new Hero(col, row, direction);
        this.board = new Board(cells, this.hero);
    }


    private Hero hero;

    private void playGame() {

        Scanner scanner = new Scanner(System.in);
        hero = new Hero(5, 2, EAST);
        while (true) {
            board.printBoard();


            System.out.println("1. Move");
            System.out.println("2. Shoot");
            System.out.println("3. Pickup Gold");
            System.out.println("4. Quit");
            System.out.println("Choose an action:");

            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    continue;
            }
        }
    }
    private int getNewRow() {
        Hero hero = (Hero) board.getHero();
        int newRow = hero.getRow();
        switch (Direction) {
            case NORTH -> newRow--;
            case SOUTH -> newRow++;
        }
        return newRow;
    }

    private int getNewCol() {
        Hero hero = (Hero) board.getHero();
        int newCol = hero.getCol();
        switch (Direction) {
            case EAST -> newCol++;
            case WEST -> newCol--;
        }
        return newCol;
    }

}
