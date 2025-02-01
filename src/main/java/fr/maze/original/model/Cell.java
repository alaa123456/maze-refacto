package fr.maze.original.model;

import fr.maze.original.enums.Direction;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Cell {
    private final int row;
    private final int column;
    private final Map<Direction, Cell> neighbors = new HashMap<>();

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void link(Cell neighbor, Direction direction) {
        neighbors.put(direction, neighbor);
        neighbor.neighbors.put(direction.opposite(), this);
    }

    public boolean isLinked(Direction direction) {
        return neighbors.containsKey(direction);
    }
}