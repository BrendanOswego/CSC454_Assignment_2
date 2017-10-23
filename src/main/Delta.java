package main;

class Delta {

  /**
   * @param   state current state of application
   * @param   input user input taken and parsed for ease of use
   * @return  new state based on input, not directly changing current state
   */
  Store stateChange(Store state, Input input) {
    Store temp = state;
    checkChange(temp);
    checkCoffees(temp, input);
    addCoins(temp, input);
    temp.setChangePressed(input.changePressed());
    return temp;
  }

  /**
   * Helper method to check if change 'pressed', if so decreases
   * respective coins and changes machine amount
   * @param state temporary state
   */
  private void checkChange(Store state) {
    if (state.changePressed()) {
      Output[] output = Utils.dispenseChange(state);
      for (int i = 0; i < output.length; i++) {
        int machineAmount = state.getMachineAmount();
        switch (output[i]) {
        case QUARTER: {
          state.setQ(state.getQ() - 1);
          state.setMachineAmount(machineAmount - 25);
          break;
        }
        case DIME: {
          state.setD(state.getD() - 1);
          state.setMachineAmount(machineAmount - 10);
          break;
        }
        case NICKEL: {
          state.setN(state.getN() - 1);
          state.setMachineAmount(machineAmount - 5);
          break;
        }
        default: {
          break;
        }
        }
      }
    }
  }

  /**
   * Helper method checks potential of coffees, if so decreases machine
   * amount for every amount % 100
   * @param state temporary state
   * @param input user input taken and parsed for ease of use
   */
  private void checkCoffees(Store state, Input input) {
    while ((state.getMachineAmount() / 100) > 0) {
      state.setMachineAmount(state.getMachineAmount() - 100);
    }
  }

  /**
   * Helper method add coins to state and sets machine amount,
   * based on coin values
   * @param state temporary state
   * @param input user input taken and parsed for ease of use
   */
  private void addCoins(Store state, Input input) {
    state.setQ(state.getQ() + input.getQ());
    state.setD(state.getD() + input.getD());
    state.setN(state.getN() + input.getN());
    int addedAmount = (input.getQ() * 25) + (input.getD() * 10) + (input.getN() * 5);
    state.setMachineAmount(state.getMachineAmount() + addedAmount);
  }

}