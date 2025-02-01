package fr.maze.original.service;


import fr.maze.original.model.Maze;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MazeServiceTest {

    @Test
    void testRenderMaze() {
        // GIVEN
        Maze maze = new Maze(3, 3);
        // WHEN
        String renderedMaze = MazeService.render(maze);

        // THEN
        assertNotNull(renderedMaze);
        assertTrue(renderedMaze.contains("+"));
        assertTrue(renderedMaze.contains("|"));
        assertTrue(renderedMaze.contains("---"));
    }

}