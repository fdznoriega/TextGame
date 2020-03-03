package Domain.Entities;

// considering type definitions
// treasure : stepping on gives a predetermined item.
// boss : stepping on gives a boss battle
// spawn : stepping on does nothing for now. maybe escape?
// obstacle : space which cannot be stepped on.
// path : stepping on does nothing.


public enum TileType {
  Path, Obstacle, Enemy, Treasure, Boss, Spawn;
}
