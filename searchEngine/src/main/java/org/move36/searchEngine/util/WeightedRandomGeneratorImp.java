package org.move36.searchEngine.util;

import java.util.Arrays;
import java.util.Random;

public class WeightedRandomGeneratorImp implements WeightedRandomGenerator {

	double[] totals;

	public WeightedRandomGeneratorImp(double[] weights) {
		totals = new double[weights.length];
		initWRNG(weights);
	}

	/*
	 * Initializing function of Random Number generator
	 * 
	 * @param weights in a double array. Note that the weights here are assumed to
	 * be positive. If there are negative ones. Sort the totals array before the
	 * binary search
	 */
	private void initWRNG(double[] weights) {
		double runningTotal = 0;
		int i = 0;
		for (double w : weights) {
			runningTotal += w;
			totals[i++] = runningTotal;
		}
	}

	/*
	 * @return the weighted random number. Actually this sends the weighted
	 * randomly selected index of weights vector.
	 */
	@Override
	public int next() {
		Random rnd = new Random(System.nanoTime());
		double rndNum = rnd.nextDouble() * totals[totals.length - 1];
		int sNum = Arrays.binarySearch(totals, rndNum);
		int idx = (sNum < 0) ? (Math.abs(sNum) - 1) : sNum;
		return idx;
	}
}
