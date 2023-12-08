/*package hu.nye.progtech.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        Hero defaultHero = new Hero(0, 0, Direction.NORTH);
        board = new Board(new CellType[3][3], defaultHero);
    }

    @Test
    void testConstructorWithValidFilePath() {
        // Given
        String filePath = "src/test/resources/valid_board.txt";

        // When
        board = new Board(filePath);

        // Then

        assertNotNull(board);
            }

    @Test
    void testConstructorWithInvalidFilePath() {
        // Given
        String filePath = "nonexistent_file.txt";

        // When
        board = new Board(filePath);

        // Then

        assertNotNull(board);

    }

  /*  @Test
    void testPrintBoard() {
        // Given

        CellType[][] cells = {
                {CellType.WALL, CellType.EMPTY, CellType.HERO},
                {CellType.GOLD, CellType.PIT, CellType.WUMPUS},
                {CellType.EMPTY, CellType.WALL, CellType.EMPTY}
        };
        Hero testHero = new Hero(2, 0, Direction.EAST);
        board = new Board(cells, testHero);

        // When

        final String printedBoard = TestUtils.captureSystemOut(() -> board.printBoard());

        // Then

        assertEquals("W - H \nG P U \n- W - \n", printedBoard);
    } */

  /*  @Test
    void testInitializeBoard() throws IOException {
        // Given
        String fileContent = "3 1 1 NORTH\nW-U\n-P-\n---\n";
        BufferedReader bufferedReader = new BufferedReader(new StringReader(fileContent));

        // When
        board.initializeBoard(bufferedReader, 3);

        // Then

        assertEquals(CellType.WALL, board.cells[0][0]);
        assertEquals(CellType.WUMPUS, board.cells[0][2]);
        assertEquals(CellType.PIT, board.cells[1][1]);

    }


} */

