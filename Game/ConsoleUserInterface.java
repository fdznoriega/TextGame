package Game;

import Domain.Interactors.IInventoryInteractorOutput;
import Domain.Interactors.IMazeInteractorOutput;
import Domain.Entities.Inventory;
import Domain.Entities.Maze;

//implements many interactors?
public class ConsoleUserInterface implements IInventoryInteractorOutput, IMazeInteractorOutput {

  //Inventory Interactor Section
  public void showBag(Inventory i) {
    System.out.println(i.bag.toString());
  }

  public void showEquipment(Inventory i) {
    System.out.println(i.equipment.toString());
  }

  public void showInventory(Inventory i) {
    System.out.println(i.toString());
  }

  public void showBagIsFull() {
    System.out.println(">Bag is full");
  }

  public void showEquipmentIsFull() {
    System.out.println(">Equipment is full");
  }

  public void showCannotEquip() {
    System.out.println(">Could not equip item");
  }

  public void showItemNotFound() {
    System.out.println(">Could not find item");
  }

  public void showSuccess() {
    System.out.println(">Success");
  }

  //Maze Interactor section
  public void showMaze(Maze m) {
    System.out.println(m.toString());
  }

  public void showInitializeSuccess() {
    System.out.println(">Maze Initialized");
  }

  public void showDimensionSuccess() {
    System.out.println(">Dimensions calculated");
  }

  public void showMatrixSuccess() {
    System.out.println(">Matrix setup success");
  }

  public void showMatrixFailure() {
    System.out.println(">Matrix setup failure");
  }

  public void showDimensionFailure() {
    System.out.println(">Dimensions not calculated");
  }

  public void showReadFailure() {
    System.out.println(">Could not read file");
  }

  public void showReadSuccess() {
    System.out.println(">File read successfully");
  }

  public void showFindSpawnFailure() {
    System.out.println(">Could not find spawn");
  }
  public void showFindSpawnSuccess() {
    System.out.println(">Found spawn successfully");
  }



}
