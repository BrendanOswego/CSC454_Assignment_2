package main;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		start();
	}

	private static void start() {
		System.out.println("Enter command any combination of q n d cancel wait");
		Scanner sc = new Scanner(System.in);
		//q, d, n, machineAmount, coffees, changePressed
		Store initialState = new Store (5, 2, 3, 0, 0, false);
		VendingMachine vm = new VendingMachine(initialState);
		String userInput = sc.nextLine();
		while (!userInput.equals("quit")) {
			String[] input = userInput.split(" ");
			vm.parseInput(input);
			userInput = sc.nextLine();
		}
	}
}
