package main;

class Store {
  private int quarters;
  private int dimes;
  private int nickels;
  private int machineAmount;
  private int coffees;
  private boolean changePressed;
  
  Store() {
    quarters = 0;
    dimes = 0;
    nickels = 0;
    machineAmount = 0;
    coffees = 0;
    changePressed = false;
  }

  Store (int quarters, int dimes, int nickels,
          int machineAmount, int coffees, boolean changePressed) {
    this.quarters = quarters;
    this.dimes = dimes;
    this.nickels = nickels;
    this.machineAmount = machineAmount;
    this.coffees = coffees;
    this.changePressed = changePressed;
  }
  
  void setQuarters (int quarters) {
    this.quarters = quarters;
  }

  void setDimes (int dimes) {
    this.dimes = dimes;
  }

  void setNickels (int nickels) {
    this.nickels = nickels;
  }

  void setChangePressed (boolean changePressed) {
    this.changePressed = changePressed;
  }

  void setMachineAmount (int machineAmount) {
    this.machineAmount = machineAmount;
  }

  void setCoffees (int coffees) {
    this.coffees = coffees;
  }

  int getQuarters () {
    return quarters;
  }
  
  int getDimes () {
    return dimes;
  }

  int getNickels () {
    return nickels;
  }

  boolean getChangePressed () {
    return changePressed;
  }

  int getMachineAmount () {
    return machineAmount;
  }

  int getCoffees () {
    return coffees;
  }

  @Override
  public String toString () {
    return "Quarters: " + quarters + '\n' + "Dimes: " + dimes + '\n' + 
      "Nickels: " + nickels + '\n' + "Coffees: " + coffees + '\n' +
      "Current Amount: " + machineAmount + '\n' + "Change Pressed: " + changePressed;
  }

}