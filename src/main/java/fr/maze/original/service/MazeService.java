package fr.maze.original.service;

import fr.maze.original.enums.Direction;
import fr.maze.original.model.Cell;
import fr.maze.original.model.Maze;

public class MazeService {
    public static String render(Maze maze) {
        StringBuilder sb = new StringBuilder();
        Cell[][] grid = maze.getGrid();
        int columns = grid[0].length;

        // Draw the top border
        sb.append("+");
        sb.append("---+".repeat(columns));
        sb.append("\n");

        // Draw the maze
        for (Cell[] row : grid) {
            StringBuilder top = new StringBuilder("|");
            StringBuilder bottom = new StringBuilder("+");

            for (Cell cell : row) {
                // Draw the east boundary
                boolean isLinkedEast = cell.isLinked(Direction.EAST);
                top.append("   ").append(isLinkedEast ? " " : "|");

                // Draw the south boundary
                boolean isLinkedSouth = cell.isLinked(Direction.SOUTH);
                bottom.append(isLinkedSouth ? "   " : "---").append("+");
            }

            sb.append(top).append("\n");
            sb.append(bottom).append("\n");
        }

        return sb.toString();
    }
}