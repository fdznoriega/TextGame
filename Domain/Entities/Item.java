package Domain.Entities;

public class Item {

  public String name;
  public ItemType type;
  public int id;

  public String toString() {
    return "[ Item Name: " + name + ", Type: " + type +  ", Id " + id + " ]";
  }


}
