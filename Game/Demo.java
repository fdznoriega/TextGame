package Game;

import Domain.Entities.*;
import Domain.Interactors.*;
import Domain.Interfaces.*;
import Domain.IO.*;

public class Demo {
  public static void main(String[] args) {
    System.out.println("Pizza Time");
    // Create IO
    ConsoleInput ci = new ConsoleInput();
    ConsoleOutput co = new ConsoleOutput();
    // Insert into game director
    GameDirector g = new GameDirector(ci, co);
    // Set up maze
    g.loadMap("Square");
    Boolean gameOver = false;
    Boolean victory = false;
    // game loop
    while(!gameOver && !victory) {
      ci.fetch();
      switch(ci.text) {
        case "north": g.move(Direction.North); break;
        case "south": g.move(Direction.South); break;
        case "east": g.move(Direction.East); break;
        case "west": g.move(Direction.West); break;
        case "exit": gameOver = true; break;
      }
    }
  }
}
