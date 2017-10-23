package main;

class Lambda {

  /**
   * @param state temporary state
   * @return  Ouput based on whether change pressed, coffee is available to dispense, or nothing
   */
  Output[] output(Store state) {
    if (state.changePressed()) {
      return Utils.dispenseChange(state);
    }
    if (state.getMachineAmount() >= 100) {
      return dispenseCoffee(state);
    }
    return new Output[] { Output.NOTHING };
  }

  /**
   * @return  list where each element is a coffee Ouput
   */
  private Output[] dispenseCoffee(Store state) {
    int coffees = state.getMachineAmount() / 100;
    Output[] output = new Output[coffees];
    for (int i = 0; i < coffees; i++) {
      output[i] = Output.COFFEE;
    }
    return output;
  }
}