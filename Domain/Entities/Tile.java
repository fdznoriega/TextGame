package Domain.Entities;

import Domain.Entities.TileType;

// a maze is composed of tiles! duh!

public class Tile {
  public TileType type;
  public int id;

  // basic constructor
  public Tile(TileType t, int i) {
    this.type = t;
    this.id = i;
  }

  // format: (AA,1)
  public Tile(String s) {
    String inner = "";
    TileType t = null;
    int id = 0;
    if(s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')') {
      for(int i = 1; i < s.length(); i++) {
        // if ',' -> end of type
        if(s.charAt(i) == ',') {
          // inner is the type so use the switch statement
          switch(inner) {
            case "PA":
                    t = TileType.Path;
                    break;
            case "OB":
                    t = TileType.Obstacle;
                    break;
            case "EN":
                    t = TileType.Enemy;
                    break;
            case "BS":
                    t = TileType.Boss;
                    break;
            case "TS":
                    t = TileType.Treasure;
                    break;
            case "SP":
                    t = TileType.Spawn;
                    break;
            default: return;
          }
          // reset inner
          inner = "";
        }
        else if(s.charAt(i) == ')') {
          // inner is the ID
          id = Integer.parseInt(inner);
          // we're done.
          break;
        }
        else if(s.charAt(i) == ' ') {
          // ignore.
        } else {
          inner += String.valueOf(s.charAt(i));
        }

      }
    }
    this.type = t;
    this.id = id;
  }

  public String toString() {
    return "[ " + type + " | " + id + " ]";
  }

}
