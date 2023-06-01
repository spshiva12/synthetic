package examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class LetterCombinationGenerator {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the length of the combinations:");
//		int length = scanner.nextInt();
//		scanner.close();

		String len = JOptionPane.showInputDialog("Enter the length of the combinations:");
		int maxLength = Integer.parseInt(len);

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int numLetters = rightLimit - leftLimit + 1;

		String fileName = "output_" + maxLength + ".txt";

		int count = 1;
		while (new File(fileName).exists()) {
			fileName = "output_" + maxLength + "_" + count + ".txt";
			count++;
		}

		try {
			PrintWriter writer = new PrintWriter(new File(fileName));
			for (int length = 1; length <= maxLength; length++) {
				int numCombinations = (int) Math.pow(numLetters, length);
				for (int i = 0; i < numCombinations; i++) {
					StringBuilder sb = new StringBuilder();
					int temp = i;
					for (int j = 0; j < length; j++) {
						int index = temp % numLetters;
						sb.append((char) (leftLimit + index));
						temp /= numLetters;
					}
					writer.println(sb.reverse().toString());
				}
			}
			writer.close();
			System.out.println("Output written to output.txt" + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

}
