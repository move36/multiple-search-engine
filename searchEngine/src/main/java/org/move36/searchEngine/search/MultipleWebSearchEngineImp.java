package org.move36.searchEngine.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of a multiple engines searcher.
 * 
 * @author javiersevilla
 * 
 */
public class MultipleWebSearchEngineImp implements MultipleWebSearchEngine {

	private WebSearchEngine[] engines;
	private WebResultsSorter sorter;

	/**
	 * The constructor need a WebResultsSorter and at least one WebSearchEngine
	 * 
	 * @param sorter
	 * @param engines
	 */
	public MultipleWebSearchEngineImp(WebResultsSorter sorter, WebSearchEngine... engines) {
		super();
		this.sorter = sorter;
		this.engines = engines;
	}

	@Override
	public void setEngines(WebSearchEngine[] engines) {
		this.engines = engines;
	}

	@Override
	public WebResultsSorter getSorter() {
		return sorter;
	}

	@Override
	public void setSorter(WebResultsSorter sorter) {
		this.sorter = sorter;
	}

	@Override
	public List<WebSearchResult> search(String term) throws Exception {
		List<List<WebSearchResult>> results = new ArrayList<List<WebSearchResult>>();
		for (WebSearchEngine engine : engines) {
			results.add(engine.search(term));
		}
		return sorter.sort(results);
	}
}
