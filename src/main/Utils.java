package main;

import java.util.ArrayList;
import java.util.List;

class Utils {

  /**
   * Dispense change based on current state, does not change state, only shows output
   * @return list of outputs where each element corresponds to coin that should
   * be output, or throws ChangeException if change cannot be dispensed based on current
   * available coins, and coins that have to be dispensed in order to give correct change
   */
  static Output[] dispenseChange(Store state) {
    List<Output> output = new ArrayList<>();
    int tempAmount = state.getMachineAmount();
    int totalQ = state.getQ();
    int totalD = state.getD();
    int totalN = state.getN();
    int qDispensed = 0, dDispensed = 0, nDispensed = 0;
    while (((tempAmount / 25) > 0) && (totalQ > qDispensed)) {
      qDispensed++;
      tempAmount -= 25;
    }
    while (((tempAmount / 10) > 0) && (totalD > dDispensed)) {
      dDispensed++;
      tempAmount -= 10;
    }
    while (((tempAmount / 5) > 0) && (totalN > nDispensed)) {
      nDispensed++;
      tempAmount -= 5;
    }
    if (tempAmount > 0) {
      throw new ChangeException();
    }
    int i;
    for (i = 0; i < qDispensed; i++)
      output.add(Output.QUARTER);
    for (i = 0; i < dDispensed; i++)
      output.add(Output.DIME);
    for (i = 0; i < nDispensed; i++)
      output.add(Output.NICKEL);
    return output.toArray(new Output[output.size()]);
  }

}
