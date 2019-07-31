package Domain.Entities;

public class Item {

  public String name;
  public ItemType type;
  public int id;

  public Item(String n, ItemType t, int i) {
    name = n;
    type = t;
    id  = i;

  }

  public String toString() {
    return "[ Item Name: " + name + ", Type: " + type +  ", Id: " + id + " ]";
  }


}
