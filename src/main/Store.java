package main;

class Store {
  private int quarters;
  private int dimes;
  private int nickels;
  private int machineAmount;
  private int coffees;
  private boolean changePressed;

  Store(int quarters, int dimes, int nickels) {
    this.quarters = quarters;
    this.dimes = dimes;
    this.nickels = nickels;
    this.machineAmount = 0;
    this.coffees = 0;
    this.changePressed = false;
  }

  void setQ(int quarters) {
    this.quarters = quarters;
  }

  void setD(int dimes) {
    this.dimes = dimes;
  }

  void setN(int nickels) {
    this.nickels = nickels;
  }

  void setChangePressed(boolean changePressed) {
    this.changePressed = changePressed;
  }

  void setMachineAmount(int machineAmount) {
    this.machineAmount = machineAmount;
  }

  void setCoffees(int coffees) {
    this.coffees = coffees;
  }

  int getQ() {
    return quarters;
  }

  int getD() {
    return dimes;
  }

  int getN() {
    return nickels;
  }

  boolean changePressed() {
    return changePressed;
  }

  int getMachineAmount() {
    return machineAmount;
  }

  int getCoffees() {
    return coffees;
  }

  @Override
  public String toString() {
    return "Quarters: " + quarters + '\n' + "Dimes: " + dimes + '\n' + "Nickels: " + nickels + '\n' + "Coffees: "
        + coffees + '\n' + "Current Amount: " + machineAmount + '\n' + "Change Pressed: " + changePressed;
  }

}