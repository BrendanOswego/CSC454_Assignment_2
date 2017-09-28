package main;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		start();
	}

	private static void start() {
		System.out.println("Enter command any combination of q n d cancel wait change");
		Scanner sc = new Scanner(System.in);
		VendingMachine vm = new VendingMachine();
		String userInput = sc.nextLine();
		while (!userInput.equals("quit")) {
			String[] input = userInput.split(" ");
			vm.applyStateChange(input);
			userInput = sc.nextLine();
		}
	}
}
