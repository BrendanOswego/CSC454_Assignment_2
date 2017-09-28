package main;

class VendingMachine implements Model {
	private int quarters;
	private int dimes;
	private int nickels;
	private int machineAmount;
	private int coffees;
	private boolean changePressed = false;
	private int count;

	VendingMachine() {
		quarters = 0;
		dimes = 0;
		nickels = 0;
		count = 0;
		machineAmount = 0;
		coffees = 0;
	}

	@Override
	public void applyStateChange(String[] change) {
		int length = change.length;
		for (int i = 0; i < length; i++) {
			checkForCoffee();
			switch (change[i]) {
				case "n": {
					nickels += 1;
					machineAmount += 5;
					System.out.println("Current Amount: " + machineAmount);
					break;
				}
				case "d": {
					dimes += 1;
					machineAmount += 10;
					System.out.println("Current Amount: " + machineAmount);
					break;
				}
				case "q": {
					quarters += 1;
					machineAmount += 25;
					System.out.println("Current Amount: " + machineAmount);
					break;
				}
				case "cancel": {
					reset();
					break;
				}
				case "wait": {
					break;
				}
				case "change": {
					dispenseChange();
					changePressed = true;
					break;
				}
				default: {
					System.out.println("Invalid type");
					return;
				}
			}
			checkForCoffee();
		}
		displayInfo();
	}

	private void displayInfo() {
		System.out.println();
		System.out.println("Vending Machine info:");
		System.out.println("----------");
		System.out.printf("Quarters Added: %d \nDimes Added: %d\nNickels Added: %d\n" +
										"Amount in Machine: %d\nCoffees Dispensed: %d\n" +
										"Change Pressed: %b\n",
						quarters, dimes, nickels, machineAmount, coffees, changePressed);
		System.out.println("----------");
		System.out.println();
	}

	private void reset() {
		machineAmount = 0;
		quarters = 0;
		nickels = 0;
		dimes = 0;
		changePressed = false;
	}

	private void dispenseChange() {
		int nCount = 0, dCount = 0, qCount = 0;
		if (machineAmount == 0) {
			System.out.println("No change to be dispensed");
			return;
		}
		System.out.println("Dispensing Change:");
		System.out.println("----------");
		while ((machineAmount / 25) > 0) {
			qCount++;
			machineAmount -= 25;
			quarters = qCount;
		}
		while ((machineAmount / 10) > 0) {
			dCount++;
			machineAmount -= 10;
			dimes = dCount;
		}
		while ((machineAmount / 5) > 0) {
			nCount++;
			machineAmount -= 5;
			nickels = nCount;
		}
		System.out.printf("Change:\nQuarters: %d\nDimes: %d\nNickels: %d\n",
						qCount, dCount, nCount);
		System.out.println("----------");
	}

	private void checkForCoffee() {
		if (machineAmount >= 100) {
			coffees++;
			while (machineAmount > 0 && machineAmount % 100 == 0) {
				machineAmount -= 100;
			}
		}
	}
}
