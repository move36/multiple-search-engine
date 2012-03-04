package org.move36.searchEngine.search;

import java.util.List;

/**
 *A simple web search engine
 * 
 * @author javiersevilla
 * 
 */
public interface WebSearchEngine {
	/**
	 * 
	 * @param term
	 *          , is the term to search
	 * @return the results of the search in a list of WebSearchResults
	 */
	List<WebSearchResult> search(String term);

	/**
	 * Retrives the Name of the engine
	 * 
	 * @return
	 */
	String getEngineName();

}
