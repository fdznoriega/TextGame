package Domain.Entities;

import Domain.Entities.TileType;

// the maze is composed of tiles.
// current tile IDs:
// 0 - Wall
// 1 - Spawn
// 2 - Walkable
// 3 - Treasure
// 4 - Refresh
// 5 - Enemy
// 6 - Boss
// there should be tile types!
// environment type -> path, wall
// treasure type -> randomized treasure specific treasure)
// enemy type -> boss, enemy

public class Tile {
  TileType type;
  int id;
}
