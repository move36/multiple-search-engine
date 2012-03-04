package org.move36.searchEngine.search.sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.move36.searchEngine.search.WebResultsSorter;
import org.move36.searchEngine.search.WebSearchResult;
import org.move36.searchEngine.util.WeightedRandomGenerator;
import org.move36.searchEngine.util.WeightedRandomGeneratorImp;

/**
 * 
 * Sort the results of the list of results generating a unique list with the
 * results sorted in a random weighting way.
 * 
 * for example: if the definition of the weigh is { 60.0d, 30.0d, 10.0d} the
 * probability of add a number of the first list is 60%, the second 30% and the
 * third 10%. When all the elements of a list are taken the probability of that
 * list is set to 0.
 * 
 * @author javiersevilla
 * 
 */
public class WeightedSorter implements WebResultsSorter {

	private double[] weights;

	public WeightedSorter(double[] weights) throws Exception {
		super();
		this.setWeights(weights);
	}

	public WeightedSorter() {
		super();
	}

	public double[] getWeights() {
		return weights;
	}

	/**
	 * Assigns the weights of the lists. If the weights don't sum 100 or there are
	 * a probability with value less than 0, the method will throw an exception.
	 * 
	 * @param weights
	 * @throws Exception
	 */
	public void setWeights(double[] weights) throws Exception {
		double sum = 0.0d;
		for (double n : weights) {
			if (n <= 0) {
				throw new Exception("Weight less than 0");
			}
			sum += n;
		}
		if (sum != 100.0d) {
			throw new Exception("Weight sum not equal at 100");
		}
		this.weights = weights;
	}

	@Override
	public List<WebSearchResult> sort(List<List<WebSearchResult>> results) throws Exception {
		if (results.size() != this.weights.length) {
			throw new Exception("Different amount of engines and weights");
		}

		double[] weightsAux = Arrays.copyOf(weights, weights.length);

		List<Iterator<WebSearchResult>> iterators = new ArrayList<Iterator<WebSearchResult>>();
		for (List<WebSearchResult> l : results) {
			iterators.add(l.iterator());
		}
		WeightedRandomGenerator wrg = new WeightedRandomGeneratorImp(weightsAux);
		int totalLeft = getTotalSize(results);
		List<WebSearchResult> sortedResults = new ArrayList<WebSearchResult>();
		while (totalLeft != 0) {
			int index = wrg.next();
			if (iterators.get(index).hasNext()) {
				sortedResults.add(iterators.get(index).next());
				totalLeft--;
			} else {
				weightsAux[index] = 0.0d;
				wrg = new WeightedRandomGeneratorImp(weightsAux);
			}
		}

		return sortedResults;
	}

	private int getTotalSize(List<List<WebSearchResult>> results) {
		int length = 0;
		for (List<WebSearchResult> l : results) {
			length += l.size();
		}
		return length;
	}
}
