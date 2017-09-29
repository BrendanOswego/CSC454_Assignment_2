package main;

//Change is given based on the amount of coins in machine
class VendingMachine implements Model {

	Store store;
  

	VendingMachine (Store store) {
		this.store = store;
	}

	public void parseInput (String[] input) {
		checkCoffees();
		int length = input.length;
		Store tempStore = this.store;
		int qCount = tempStore.getQuarters();
		int dCount = tempStore.getDimes();
		int nCount = tempStore.getNickels();
		int machineAmount = tempStore.getMachineAmount();
		boolean changePressed = tempStore.getChangePressed();
		boolean isWaiting = false;
		for (String s : input) {
			switch (s) {
				case "q": {
					qCount++;
					machineAmount += 25;
					break;
				}
				case "d": {
					dCount++;
					machineAmount += 10;
					break;
				}
				case "n": {
					nCount++;
					machineAmount += 5;
					break;
				}
				case "cancel": {
					dispenseChange();
					return;
				}
				case "wait": {
					isWaiting = true;
					break;
				}
				default: {
					System.out.println("Invalid input");
					return;
				}
			}
		}
		if (!isWaiting) {
			displayInfo();
			tempStore.setQuarters(qCount);
			tempStore.setDimes(dCount);
			tempStore.setNickels(nCount);
			tempStore.setMachineAmount(machineAmount);
		} else {
			tempStore.setQuarters(qCount);
			tempStore.setDimes(dCount);
			tempStore.setNickels(nCount);
			tempStore.setMachineAmount(machineAmount);
			displayInfo();
		}
		applyStateChange(tempStore);
	}

	@Override
	public Store getState () {
		return store;
	}

	@Override
	public void applyStateChange (Store newStore) {
		this.store = newStore;
	}

	private void displayInfo () {
		System.out.println(getState());
	}

	private void checkCoffees () {
		Store tempStore = this.store;
		int machineAmount = tempStore.getMachineAmount();
		int coffees = tempStore.getCoffees();
		int tempCoffees = 0;
		while ((machineAmount / 100) > 0) {
			tempCoffees++;
			machineAmount -= 100;
		}
		tempStore.setCoffees(coffees + tempCoffees);
		tempStore.setMachineAmount(machineAmount);
	}

	private void dispenseChange () {
		Store tempStore = this.store;
		int machineAmount = tempStore.getMachineAmount();
		if (machineAmount == 0) {
			System.out.println("There is no change to be dispensed");
			return;
		}
		int qDispense = 0, dDispense = 0, nDispense = 0;
		int qCount = tempStore.getQuarters();
		int dCount = tempStore.getDimes();
		int nCount = tempStore.getNickels();
		while ((machineAmount / 25) > 0) {
			if (nCount >= 5) {
				nDispense +=5;
				machineAmount -=25;
			} else if (qCount > qDispense) {
				qDispense++;
				machineAmount -= 25;
			} else {
				System.out.println("Not enough quarters");
			}
		}
		while ((machineAmount / 10) > 0) {
			if (dCount > dDispense) {
				dDispense++;
				machineAmount -=10;
			} else {
				System.out.println("Not enough dimes");
			}
		}
		while ((machineAmount / 5) > 0) {
			if (nCount > nDispense) {
				nDispense++;
				machineAmount -= 5;
			} else {
				System.out.println("Not enough nickels");
			}
		}
		tempStore.setQuarters(qCount - qDispense);
		tempStore.setDimes(dCount - dDispense);
		tempStore.setNickels(nCount - nDispense);
		tempStore.setMachineAmount(machineAmount);
		tempStore.setChangePressed(true);
		displayInfo();
		tempStore.setChangePressed(false);
		applyStateChange(tempStore);
	}
}
