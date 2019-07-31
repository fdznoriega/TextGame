//defines player inventory and its actions
package Domain.Entities;

public class Inventory {

  public Item[] bag = new Item[10]; //limit: 10 items
  public Item[] equipment = new Item[3];   //limit: 3 items

  public String toString() {
    String string = "";
    if(bag != null) {
      string += bagToString();
    }
    else {
      string += "Empty/Null" + "\n";
    }
    if(equipment != null){
      string += equipmentToString();
    }
    else {
      string += "Empty/Null" + "\n";
    }
    return string;
  }

  public String bagToString() {
    String inv = "Bag:\n";
    int counter = 0;
    while(counter < bag.length) {
      if(bag[counter] != null) {
        inv += counter + ": " + bag[counter].toString() + "\n";
        counter++;
      }
      else {
        break;
      }
    }
    return inv;
  }

  public String equipmentToString() {
    String eq = "Equipment:\n";
    int counter = 0;
    while(counter < equipment.length) {
      if(equipment[counter] != null) {
        eq += counter + ": " + equipment[counter].toString() + "\n";
        counter++;
      }
      else {
        break;
      }
    }
    return eq;
  }


}
