package org.move36.searchEngine.search;

import java.util.List;
/**
 * Class used to sort the list of list of WebSearchResult
 * @author javiersevilla
 *
 */
public interface WebResultsSorter {
/**
 * Sort the list of list of WebSearchResult returning a unique sorted list
 * 
 * @param results
 * @return
 * @throws Exception
 */
	List<WebSearchResult> sort(List<List<WebSearchResult>> results) throws Exception;

}
