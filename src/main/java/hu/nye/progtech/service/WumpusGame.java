package hu.nye.progtech.service;

import hu.nye.progtech.model.Board;
import hu.nye.progtech.model.CellType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WumpusGame {

        public static void main (String[]args){
            try {
                Board board = new Board("C:\\Users\\varga\\progTech\\wumpus\\src\\main\\resources\\wumpusinput");

                // Pálya kiírása a konzolra
      //          board.printBoard();

                // Játék inicializálása
                hu.nye.progtech.service.Game game = new hu.nye.progtech.service.Game(board);

                // Játék elindítása
                game.play();
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }



