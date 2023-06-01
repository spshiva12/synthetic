package phase1;

import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rounds: ");
		int rounds = scanner.nextInt();
		int start = (int) 'a';
		int end = (int) 'z';
		for (int i = 1; i <= rounds; i++) {
			System.out.println("Combinations for " + i + " round(s):");
			printCombinations(start, end, i, new StringBuilder());
			System.out.println();
		}
	}

	// Dynamically Prints all the combinations from the user given value
	// Ex: if user enters 3 it will print 1,2,3 rounds
	public static void printCombinations(int start, int end, int rounds, StringBuilder combination) {
		if (rounds == 0) {
			System.out.println(combination);
			return;
		}
		for (int i = start; i <= end; i++) {
			char c = (char) i;
			combination.append(c);
			printCombinations(start, end, rounds - 1, combination);
			combination.setLength(combination.length() - 1);
		}
	}

}
