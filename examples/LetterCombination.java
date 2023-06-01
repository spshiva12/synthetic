package examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class LetterCombination {

	public static void main(String[] args) {
		String len = JOptionPane.showInputDialog("Enter the length of the combinations:");
		int length = Integer.parseInt(len);

		String len1 = JOptionPane.showInputDialog("Enter the length of the combinations:");
		int maxCombinationsPerFile = Integer.parseInt(len1);

		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int numLetters = rightLimit - leftLimit + 1;

		int numCombinations = (int) Math.pow(numLetters, length);

		int numFiles = (int) Math.ceil((double) numCombinations / maxCombinationsPerFile);

		String baseFileName = "output_" + length;

		for (int i = 0; i < numFiles; i++) {
			int startIndex = i * maxCombinationsPerFile;
			int endIndex = Math.min(startIndex + maxCombinationsPerFile, numCombinations);
			String fileName = baseFileName + "_" + (i + 1) + ".txt";
			try {
				PrintWriter writer = new PrintWriter(new File(fileName));
				for (int j = startIndex; j < endIndex; j++) {
					StringBuilder sb = new StringBuilder();
					int temp = j;
					for (int k = 0; k < length; k++) {
						int index = temp % numLetters;
						sb.append((char) (leftLimit + index));
						temp /= numLetters;
					}
					writer.println(sb.reverse().toString());
				}
				writer.close();
				System.out.println("Output written to " + fileName);
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred: " + e.getMessage());
			}
		}
	}

}
