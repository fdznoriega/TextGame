package Game;

import Domain.Entities.Inventory;
import Domain.Entities.Maze;
import Domain.Interfaces.*;

//implements many interactors?
public class ConsoleUserInterface implements
  IInventoryInteractorOutput, IMazeInteractorOutput,
  IStatsInteractorOutput, IPlayerInteractorOutput,
  IGameDirectorOutput {

  //method to format stuff in system.out.println(argument);
  private void sopl(String s) {
    System.out.println("SYS: " + s);
  }

  //==========Inventory Interactor Section==========
  public void showBag(Inventory i) {
    sopl(i.bagToString());
  }

  public void showEquipment(Inventory i) {
    sopl(i.equipmentToString());
  }

  public void showInventory(Inventory i) {
    sopl(i.toString());
  }

  public void showBagIsFull() {
    sopl("Bag is full");
  }

  public void showEquipmentIsFull() {
    sopl("Equipment is full");
  }

  public void showCannotEquip() {
    sopl("Could not equip item");
  }

  public void showItemNotFound() {
    sopl("Could not find item");
  }

  public void showEquipmentCleared() {
    sopl("Equipment cleared");
  }

  public void showBagCleared() {
    sopl("Bag cleared");
  }

  public void showItemInserted() {
    sopl("Item inserted");
  }

  public void showItemRemoved() {
    sopl("Item removed");
  }

  public void showItemUnequipped() {
    sopl("Item uneqipped");
  }

  //==========Maze Interactor section==========
  public void showMaze(Maze m) {
    sopl(m.toString());
  }

  public void loadSuccess() {
    sopl("Maze loaded");
  }

  public void showFileToStringFailure() {
    sopl("Could not convert file to string");
  }

  public void showEdgesNotFound() {
    sopl("Matrix edges not found");
  }

  public void showMatrixNotSquare() {
    sopl("Level matrix is not square.");
  }

  public void showFindSpawnFailure() {
    sopl("Could not find spawn");
  }

  public void showMazeNotInitialized() {
    sopl("Maze not initialized");
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
    if(amt == 1) {
      sopl("Level down?!");
    }
    else {
      sopl("Level down by " + amt);
    }
  }

  public void showDecreaseExp(int amt) {
    sopl(amt + " EXP lost?!");
  }

  public void showDecreaseGold(int amt) {
    sopl(amt + " Gold lost?!");
  }

  // === Game Director Output ===
  public void showCannotMoveNorth() {
    sopl("Could not move north");
  }
  public void showCannotMoveSouth() {
    sopl("Could not move south");
  }
  public void showCannotMoveEast() {
    sopl("Could not move east");
  }
  public void showCannotMoveWest() {
    sopl("Could not move west");
  }

  public void showMovedNorth() {
    sopl("Moved North");
  }

  public void showMovedSouth() {
    sopl("Moved South");
  }

  public void showMovedEast() {
    sopl("Moved East");
  }

  public void showMovedWest() {
    sopl("Moved West");
  }







}
