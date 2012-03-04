package org.move36.searchEngine.search.sorters;

import java.util.Arrays;
import java.util.List;

import org.move36.searchEngine.search.WebResultsSorter;
import org.move36.searchEngine.search.WebSearchResult;

/**
 * Sort the results of the list of results generating a unique list with the
 * results sorted in a total balanced way.
 * 
 * for example: for list [1,2,3,4] and [5,6,7,8] the result is [1,5,2,6,3,7,4,8]
 * 
 * @author javiersevilla
 * 
 */
public class BalancedSorter implements WebResultsSorter {

	@Override
	public List<WebSearchResult> sort(List<List<WebSearchResult>> results) {
		int length = 0;
		for (List<WebSearchResult> l : results) {
			length += l.size();
		}
		WebSearchResult result[] = new WebSearchResult[length];
		for (int i = 0, j = 0; j < length; ++i) {
			for (List<WebSearchResult> l : results) {
				if (i < l.size()) {
					result[j++] = l.get(i);
				}
			}
		}
		return Arrays.asList(result);
	}

}
