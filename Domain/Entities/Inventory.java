//defines player inventory and its actions
package Domain.Entities;

public class Inventory {

  public Item[] bag; //limit: 10 items
  public Item[] equipment;   //limit: 3 items

  public Inventory() {
    bag = new Item[10];
    equipment = new Item[3];
  }

  public String toString() {
    String string = "";
    if(bag != null) {
      string += bagToString();
    }
    else {
      string += "Empty/Null" + "\n";
    }
    if(equipment != null){
      string += "\n" + equipmentToString();
    }
    else {
      string += "Empty/Null" + "\n";
    }
    return string;
  }

  public String bagToString() {
    String inv = "Bag:";
    int counter = 0;
    while(counter < bag.length) {
      if(bag[counter] != null) {
        inv += "\n" + counter + ": " + bag[counter].toString();
      }
      counter++;
    }
    return inv;
  }

  public String equipmentToString() {
    String eq = "Equipment:";
    int counter = 0;
    while(counter < equipment.length) {
      if(equipment[counter] != null) {
        eq += "\n" + counter + ": " + equipment[counter].toString();
      }
      counter++;
    }
    return eq;
  }


}
