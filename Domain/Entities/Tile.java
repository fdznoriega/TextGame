package Domain.Entities;

import Domain.Entities.TileType;

// a maze is composed of tiles! duh!

public class Tile {
  TileType type;
  int id;

  public String toString() {
    return "[ " + type + " | " + id + " ]";
  }

}
