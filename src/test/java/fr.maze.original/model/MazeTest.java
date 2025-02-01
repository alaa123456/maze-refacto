package fr.maze.original.model;

import fr.maze.original.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    private Maze maze;
    private final int rows = 5;
    private final int columns = 5;

    @BeforeEach
    void setUp() {
        // GIVEN
        maze = new Maze(rows, columns);
    }

    @Test
    void testInitializeGrid() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                assertNotNull(maze.getGrid()[row][column]);
            }
        }
    }

    @Test
    void testGetNeighbor() {
        // WHEN
        Cell centerCell = maze.getGrid()[2][2];

        // THEN
        // Test North neighbor
        Cell northNeighbor = maze.getNeighbor(centerCell, Direction.NORTH);
        assertNotNull(northNeighbor, "North neighbor should not be null");
        assertEquals(1, northNeighbor.getRow());
        assertEquals(2, northNeighbor.getColumn());

        // Test South neighbor
        Cell southNeighbor = maze.getNeighbor(centerCell, Direction.SOUTH);
        assertNotNull(southNeighbor, "South neighbor should not be null");
        assertEquals(3, southNeighbor.getRow());
        assertEquals(2, southNeighbor.getColumn());

        // Test East neighbor
        Cell eastNeighbor = maze.getNeighbor(centerCell, Direction.EAST);
        assertNotNull(eastNeighbor, "East neighbor should not be null");
        assertEquals(2, eastNeighbor.getRow());
        assertEquals(3, eastNeighbor.getColumn());

        // Test West neighbor
        Cell westNeighbor = maze.getNeighbor(centerCell, Direction.WEST);
        assertNotNull(westNeighbor, "West neighbor should not be null");
        assertEquals(2, westNeighbor.getRow());
        assertEquals(1, westNeighbor.getColumn());
    }
    @Test
    void testMazeInitialization() {

        // WHEN
        Cell[][] grid = maze.getGrid();
        // THEN
        assertEquals(5, grid.length);
        assertEquals(5, grid[0].length);

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                assertNotNull(grid[row][col]);
                assertEquals(row, grid[row][col].getRow());
                assertEquals(col, grid[row][col].getColumn());
            }
        }
    }

    @Test
    void testMazeGeneration() {
        // WHEN
        Cell[][] grid = maze.getGrid();

        // THEN
        // Ensure at least one cell has a linked neighbor
        boolean hasLinkedNeighbor = false;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (!grid[row][col].getNeighbors().isEmpty()) {
                    hasLinkedNeighbor = true;
                    break;
                }
            }
        }
        assertTrue(hasLinkedNeighbor);
    }
}