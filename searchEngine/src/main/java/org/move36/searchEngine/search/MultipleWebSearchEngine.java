package org.move36.searchEngine.search;

/**
 * 
 * Interface that defines a search engine of multiple web search engines
 * 
 * @author javiersevilla
 */
import java.util.List;

public interface MultipleWebSearchEngine {
	/**
	 * Search the term in the engines that are configured
	 * 
	 * @param term
	 * @return the results of the search
	 * @throws Exception
	 */
	List<WebSearchResult> search(String term) throws Exception;

	/**
	 * Set the search engines that will use in the searches
	 * 
	 * @param engines
	 */
	void setEngines(WebSearchEngine[] engines);

	/**
	 * retrieves the configured sorter
	 * 
	 * @return the actual sorter.
	 */
	WebResultsSorter getSorter();

	/**
	 * sets a sorter to use
	 * 
	 * @param sorter
	 */
	void setSorter(WebResultsSorter sorter);

}
