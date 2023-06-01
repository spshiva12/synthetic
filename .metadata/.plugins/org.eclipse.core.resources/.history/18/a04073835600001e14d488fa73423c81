package examples;

import java.util.Random;

public class SyntheticDataGenerator {

	public static void main(String[] args) {
		Random random = new Random();
		double mean = 0.0;
		double stdDev = 1.0;
		int numSamples = 1000;

		for (int i = 0; i < numSamples; i++) {
			double sample = mean + stdDev * random.nextGaussian();
			System.out.println(sample);
		}
	}

}
