package Game;

import Domain.Entities.*;
import Domain.Interactors.*;
import Domain.Interfaces.*;
import Domain.IO.*;

public class Game {

  public static void main(String[] args) {
    //Player - stats, inven
    //Player interactor - modifies player's stats and inven
    //Game state - explore, battle, pause, game over
    System.out.println("game time");
    GameDirector g;
    g = new GameDirector(new ConsoleInput(), new ConsoleOutput());

  }

}
