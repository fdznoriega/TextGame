package Game;

import Domain.Entities.Inventory;
import Domain.Entities.Maze;
import Domain.Interfaces.*;

//implements many interactors?
public class ConsoleUserInterface implements
  IInventoryInteractorOutput, IMazeInteractorOutput,
  IStatsInteractorOutput {

  //method to format stuff in system.out.println(argument);
  private void sopl(String s) {
    System.out.println(">>" + s);
  }

  //==========Inventory Interactor Section==========
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

  //==========Maze Interactor section==========
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

  //==========Stats Interactor Section==========

  public void showUpdateSuccess() {
    sopl("Stats updated");
  }

  public void showUpdateFailure() {
    sopl("Stats not updated");
  }

  public void showNoChange() {
    sopl("No change");
  }

  public void showHpAlreadyMax() {
    sopl("Current HP already at max");
  }

  public void showFullyHealed() {
    sopl("Fully healed");
  }

  public void showIncreaseCurrentHp(int amt) {
    sopl(amt + " HP gained");
  }

  public void showIncreaseMaxHp(int amt) {
    sopl("Max HP up by " + amt);
  }

  public void showIncreaseAttack(int amt) {
    sopl("Attack up by " + amt);
  }

  public void showIncreaseDefense(int amt) {
    sopl("Defense up by " + amt);
  }

  public void showIncreaseSpeed(int amt) {
    sopl("Speed up by " + amt);
  }

  public void showIncreaseLevel(int amt) {
    if(amt == 1) {
      sopl("Level up!");
    }
    else {
      sopl("Level increased by " + amt);
    }


  }

  public void showIncreaseExp(int amt) {
    sopl(amt + " EXP gained!");
  }

  public void showIncreaseGold(int amt) {
    sopl(amt + " Gold gained!");
  }

  //show decrease of individual stats.
  public void showDecreaseCurrentHp(int amt) {
    sopl(amt + " damage taken");
  }

  public void showDecreaseMaxHp(int amt) {
    sopl("Max HP down by " + amt);
  }

  public void showDecreaseAttack(int amt) {
    sopl("Attack down by " + amt);
  }

  public void showDecreaseDefense(int amt) {
    sopl("Defense down by " + amt);
  }

  public void showDecreaseSpeed(int amt) {
    sopl("Speed down by " + amt);
  }

  public void showDecreaseLevel(int amt) {
    if(amt == 1) { sopl("Level down?!");         }
    else         { sopl("Level down by " + amt); }
  }

  public void showDecreaseExp(int amt) {
    sopl(amt + " EXP lost?!");
  }
  public void showDecreaseGold(int amt) {
    sopl(amt + " Gold lost?!");
  }


}
