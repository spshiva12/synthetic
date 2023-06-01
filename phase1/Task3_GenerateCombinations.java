package phase1;

import java.util.Scanner;

public class Task3_GenerateCombinations {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rounds: ");
        int length = scanner.nextInt();
        scanner.close();

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        if (length == 1) {
            generateCombinations(alphabet, length, new StringBuilder());
        } else {
            for (int i = 1; i <= length; i++) {
                generateCombinations(alphabet, i, new StringBuilder());
            }
        }
    }

    private static void generateCombinations(char[] alphabet, int length, StringBuilder combination) {
        if (length == 0) {
            System.out.println(combination.toString());
        } else {
            for (int i = 0; i < alphabet.length; i++) {
                combination.append(alphabet[i]);
                generateCombinations(alphabet, length - 1, combination);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }

}
