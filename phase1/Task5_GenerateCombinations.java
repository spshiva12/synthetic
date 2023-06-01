package phase1;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Task5_GenerateCombinations {

	public static void main(String[] args) throws IOException {
//		long startTime = System.currentTimeMillis();

		String input = JOptionPane.showInputDialog("Enter number of rounds:");
		int length = Integer.parseInt(input);

		Instant start = Instant.now();
		LocalDateTime now = LocalDateTime.now();
		String timestamp = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(now);
		String filenamePrefix = "ds";
		String filename = filenamePrefix + length + "_" + timestamp + ".txt";

		FileWriter writer = new FileWriter(filename);
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		if (length == 1) {
			generateCombinations(alphabet, length, new StringBuilder(), writer);
		} else {

			for (int i = 1; i <= length; i++) {
				generateCombinations(alphabet, i, new StringBuilder(), writer);
			}
		}

		writer.close();

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

	private static void generateCombinations(char[] alphabet, int length, StringBuilder combination, FileWriter writer)
			throws IOException {
		if (length == 0) {
			writer.write(combination.toString() + "\n");
		} else {
			for (int i = 0; i < alphabet.length; i++) {
				combination.append(alphabet[i]);
				generateCombinations(alphabet, length - 1, combination, writer);
				combination.deleteCharAt(combination.length() - 1);
			}
		}
	}

}

////long endTime = System.currentTimeMillis();
////long elapsedTime = endTime - startTime;
////
////double elapsedSeconds = (double) elapsedTime / 1000;
////String formattedTime = String.format("%.2f seconds", elapsedSeconds);
////System.out.println("Elapsed time: " + elapsedSeconds + " seconds");
//
////System.out.println("Elapsed time: " + elapsedTime + " ms");
//Instant finish = Instant.now();
////long timeElapsed = Duration.between(start, finish).toMillis();
////System.out.println("Elapsed time: " + timeElapsed + " ms");
//Duration interval = Duration.between(start, finish);
//long elapsedSeconds = interval.getSeconds();
//long elapsedMinutes = elapsedSeconds / 60;
//long elapsedHours = elapsedMinutes / 60;
//System.out.println("Elapsed time: " + elapsedSeconds + " seconds");
//System.out.println("Elapsed time: " + elapsedMinutes + " minutes");
//System.out.println("Elapsed time: " + elapsedHours + " hours");

//FileWriter timeWriter = new FileWriter("time.txt");
//timeWriter.write("Elapsed time: " + elapsedNanos + " nanoseconds\n");
//timeWriter.write("Elapsed time: " + elapsedMillis + " milliseconds\n");
//timeWriter.write("Elapsed time: " + elapsedSeconds + " seconds\n");
//timeWriter.write("Elapsed time: " + elapsedMinutes + " minutes\n");
//timeWriter.write("Elapsed time: " + elapsedHours + " hours\n");
//timeWriter.close();
