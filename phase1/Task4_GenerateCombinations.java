package phase1;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Task4_GenerateCombinations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of rounds: ");
		int length = scanner.nextInt();
		scanner.close();
		Instant start = Instant.now();

		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		if (length == 1) {
			generateCombinations(alphabet, length, new StringBuilder());
		} else {
			for (int i = 1; i <= length; i++) {
				generateCombinations(alphabet, i, new StringBuilder());
			}
		}
		Instant finish = Instant.now();
		Duration interval = Duration.between(start, finish);
		long elapsedNanos = interval.toNanos();
		long elapsedMillis = interval.toMillis();
//		long elapsedSeconds = interval.getSeconds();
		long elapsedSeconds = elapsedMillis / 1000;
//		long elapsedMinutes = TimeUnit.SECONDS.toMinutes(elapsedSeconds);
		long elapsedMinutes = elapsedSeconds / 60;
		long elapsedHours = TimeUnit.SECONDS.toHours(elapsedSeconds);
		System.out.println("Elapsed time: " + elapsedNanos + " nanoseconds");
		System.out.println("Elapsed time: " + elapsedMillis + " milliseconds");
		System.out.println("Elapsed time: " + elapsedSeconds + " seconds");
		System.out.println("Elapsed time: " + elapsedMinutes + " minutes");
		System.out.println("Elapsed time: " + elapsedHours + " hours");
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
