package fr.maze.original;

import fr.maze.original.model.Maze;
import fr.maze.original.service.MazeService;


public class Main {

  public static void main(String[] args) {

    int rows = 7;
    int columns = 7;

    Maze maze = new Maze(rows, columns);
    String mazeDisplay = MazeService.render(maze);

    System.out.println(mazeDisplay);
  }
}