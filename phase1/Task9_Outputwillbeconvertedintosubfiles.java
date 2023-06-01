
package phase1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Task9_Outputwillbeconvertedintosubfiles {

	public static void main(String[] args) throws IOException {
		// Get the length of the data set from user input
		String input = JOptionPane.showInputDialog("Enter number of rounds:");
		int dataSetLength = Integer.parseInt(input);

		// Get the number of parts to split the output into
		String input1 = JOptionPane.showInputDialog("Enter number of parts to split the output into:");
		int numParts = Integer.parseInt(input1);

		// Generate output file name and create BufferedWriter object
		Instant start = Instant.now();
		LocalDateTime now = LocalDateTime.now();
		String timestamp = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(now);
		String dataSetPrefix = "ds";
		String outputFileName = dataSetPrefix + dataSetLength + "_" + timestamp + ".txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

		// Generate combinations and write to output file
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		if (dataSetLength == 1) {
			generateCombinations(alphabet, dataSetLength, new StringBuilder(), writer, numParts);
		} else {
			int combinationsPerPart = (int) Math.ceil(Math.pow(alphabet.length, dataSetLength) / (double) numParts);
			int combinationsWritten = 0;
			for (int i = 1; i <= dataSetLength; i++) {
				combinationsWritten += generateCombinations(alphabet, i, new StringBuilder(), writer,
						combinationsPerPart);
				if (combinationsWritten >= combinationsPerPart && i < dataSetLength) {
					writer.flush();
					writer.close();
					String partFileName = dataSetPrefix + dataSetLength + "_" + timestamp + "_part" + (i - 1) + ".txt";
					writer = new BufferedWriter(new FileWriter(partFileName));
					combinationsWritten = 0;
				}
			}
		}
		writer.close();

		// Calculate and print elapsed time
		Instant finish = Instant.now();
		Duration interval = Duration.between(start, finish);
		long elapsedNanos = interval.toNanos();
		long elapsedMillis = interval.toMillis();
		long elapsedSeconds = interval.getSeconds();
		long elapsedMinutes = TimeUnit.SECONDS.toMinutes(elapsedSeconds);
		long elapsedHours = TimeUnit.SECONDS.toHours(elapsedSeconds);
		System.out.println("Elapsed time: " + elapsedNanos + " nanoseconds");
		System.out.println("Elapsed time: " + elapsedMillis + " milliseconds");
		System.out.println("Elapsed time: " + elapsedSeconds + " seconds");
		System.out.println("Elapsed time: " + elapsedMinutes + " minutes");
		System.out.println("Elapsed time: " + elapsedHours + " hours");
	}

	private static int generateCombinations(char[] alphabet, int length, StringBuilder combination,
			BufferedWriter writer, int maxCombinations) throws IOException {
		if (length == 0) {
			// Write combination to output file
			writer.write(combination.toString() + "\n");
			return 1;
		} else {
			int combinationsWritten = 0;
			// Generate combinations recursively
			for (int i = 0; i < alphabet.length; i++) {
				combination.append(alphabet[i]);
				combinationsWritten += generateCombinations(alphabet, length - 1, combination, writer,
						maxCombinations - combinationsWritten);
				combination.deleteCharAt(combination.length() - 1);
				if (combinationsWritten >= maxCombinations) {
					break;
				}
			}
			return combinationsWritten;
		}
	}
}
