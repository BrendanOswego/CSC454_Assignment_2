package main;

class Input {
  private int quarters;
  private int dimes;
  private int nickels;
  private boolean changePressed;

  /**
   * Takes user line and parses each char adding values to respective mapping
   * @param line  java.util.Scanner line taken from user
   */
  Input(String line) {
    quarters = 0;
    dimes = 0;
    nickels = 0;
    changePressed = false;
    for (int i = 0; i < line.length(); i++) {
      switch (line.charAt(i)) {
      case 'q': {
        quarters++;
        break;
      }
      case 'd': {
        dimes++;
        break;
      }
      case 'n': {
        nickels++;
        break;
      }
      case 'c': {
        System.out.println("change pressed");
        changePressed = true;
        break;
      }
      }
    }
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
}