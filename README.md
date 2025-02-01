# Maze Generator Project

## Overview
Welcome to the Maze Generator project! 

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   ├── enums/
│   │   │   └── Direction.java
│   │   ├── model/
│   │   │   ├── Cell.java
│   │   │   └── Maze.java
│   │   └── service/
│   │       └── MazeService.java
│   └── resources/
└── test/
    ├── java/
    │   ├── enums/
    │   │   └── DirectionTest.java
    │   ├── model/
    │   │   ├── CellTest.java
    │   │   └── MazeTest.java
    │   └── service/
    │       └── MazeServiceTest.java
    └── resources/
```

## How It Works
The program initializes a grid of cells and randomly connects them to create a maze structure.


## Classes and Methods

### `Direction.java`
Defines the four cardinal directions and provides a utility method:
- `Direction opposite()`: Returns the opposite direction (e.g., NORTH ↔ SOUTH).

### `Cell.java`
Represents a single cell in the maze:
- `Cell(int row, int column)`: Initializes the cell at a specific position.
- `void link(Cell neighbor, Direction direction)`: Links the current cell to a neighboring cell.
- `boolean isLinked(Direction direction)`: Checks if a cell is linked in a given direction.

### `Maze.java`
Handles maze generation and stores the grid:
- `Maze(int rows, int columns)`: Creates a maze of specified size.
- `void initializeGrid()`: Populates the grid with cells.
- `void generateMaze()`: Randomly links cells to generate the maze structure.
- `Cell getNeighbor(Cell cell, Direction direction)`: Returns the neighboring cell in a given direction.
- `Cell getCell(int row, int column)`: Retrieves a cell at specified coordinates.

### `MazeService.java`
Provides rendering functionality:
- `String render(Maze maze)`: Returns an ASCII representation of the maze.


## Example Output
```
+---+---+---+---+---+---+---+
|                           |
+---+---+   +---+---+---+---+
|       |                   |
+   +---+   +   +---+---+   +
|       |       |           |
+---+   +---+   +---+---+   +
|               |           |
+---+---+---+   +---+---+---+
```

Enjoy generating your mazes! 🚀

