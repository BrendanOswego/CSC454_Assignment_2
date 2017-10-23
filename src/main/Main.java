package main;

import java.util.Scanner;
import java.util.Arrays;

class Main {

	private static final boolean isDev = false;

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		System.out.println(
				"Enter any combo of q n d c, or press ENTER to cause vending machine to wait (`quit` to exit program)");
		Store state = new Store(0, 0, 0);
		Lambda lambda = new Lambda();
		Delta delta = new Delta();
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		while (!userInput.equals("quit")) {
			Store temp = state;
			Output[] output = lambda.output(temp);
			System.out.println(Arrays.toString(output));

			Input input = new Input(userInput);
			state = delta.stateChange(temp, input);
			if (isDev) {
				System.out.println(state);
			}
			userInput = sc.nextLine();
		}
		sc.close();
	}
}
