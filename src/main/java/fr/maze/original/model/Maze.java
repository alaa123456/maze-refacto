package fr.maze.original.model;


import fr.maze.original.enums.Direction;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Maze {
    private final int rows;
    private final int columns;
    private final Cell[][] grid;
    private final Random random;

    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Cell[rows][columns];
        this.random = new Random();
        initializeGrid();
        generateMaze();
    }

    public void initializeGrid() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = new Cell(row, column);
            }
        }
    }

    public void generateMaze() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell currentCell = grid[row][column];
                List<Direction> availableDirections = new ArrayList<>();

                if (row > 0) availableDirections.add(Direction.NORTH);
                if (column < columns - 1) availableDirections.add(Direction.EAST);

                if (!availableDirections.isEmpty()) {
                    Direction direction = availableDirections.get(random.nextInt(availableDirections.size()));
                    Cell neighbor = getNeighbor(currentCell, direction);
                    if (neighbor != null) {
                        currentCell.link(neighbor, direction);
                    }
                }
            }
        }
    }

    public Cell getNeighbor(Cell cell, Direction direction) {
        int row = cell.getRow();
        int column = cell.getColumn();

        return switch (direction) {
            case NORTH -> getCell(row - 1, column);
            case SOUTH -> getCell(row + 1, column);
            case EAST -> getCell(row, column + 1);
            case WEST -> getCell(row, column - 1);
        };
    }

    private Cell getCell(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return grid[row][column];
        }
        return null;
    }
}

