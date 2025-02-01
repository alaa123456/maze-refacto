package fr.maze.original.model;

import fr.maze.original.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Cell cell1;
    private Cell cell2;

    @BeforeEach
    void setUp() {
        // GIVEN
         cell1 = new Cell(0, 0);
         cell2 = new Cell(0, 1);
    }


        @Test
    void testLinkNeighbor() {
        // WHEN
        cell1.link(cell2, Direction.EAST);

        // THEN
        assertTrue(cell1.isLinked(Direction.EAST));
        assertTrue(cell2.isLinked(Direction.WEST));
    }

    @Test
    void testIsLinked() {
        // WHEN
        cell1.link(cell2, Direction.EAST);
        // THEN
        assertTrue(cell1.isLinked(Direction.EAST));
        assertFalse(cell1.isLinked(Direction.NORTH));
    }
}