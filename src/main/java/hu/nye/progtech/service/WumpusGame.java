package hu.nye.progtech.service;

import hu.nye.progtech.model.Board;
import hu.nye.progtech.model.CellType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WumpusGame {

        public static void main (String[]args){
            System.out.println("Üdvözöllek dicső lovag! Szép a ruhád, szép a lovad");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Mond, hogyan szólíthatlak: ");
            String userName = scanner.nextLine();
            System.out.println("Felhasználónév: " + userName);
              try {
                Board board = new Board("C:\\Users\\varga\\progTech\\wumpus\\src\\main\\resources\\wumpusinput");

                hu.nye.progtech.service.Game game = new hu.nye.progtech.service.Game(board);

                game.play();
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }



