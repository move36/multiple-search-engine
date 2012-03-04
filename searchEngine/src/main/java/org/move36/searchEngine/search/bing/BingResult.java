package org.move36.searchEngine.search.bing;

import org.move36.searchEngine.search.WebSearchResult;

/**
 * Implementation of WebSearchResult for BingWebSearch results
 * 
 * @author javiersevilla
 * 
 */
public class BingResult implements WebSearchResult {

	private String engine;
	private String Title;
	private String Url;
	private String Description;

	public BingResult() {
		super();
		this.engine = BingWebSearch.NAME;
	}

	@Override
	public String getTitle() {
		return Title;
	}

	@Override
	public void setTitle(String Title) {
		this.Title = Title;
	}

	@Override
	public String getDescription() {
		return Description;
	}

	@Override
	public void setDescription(String Description) {
		this.Description = Description;
	}

	@Override
	public String getUrl() {
		return Url;
	}

	@Override
	public void setUrl(String Url) {
		this.Url = Url;
	}

	@Override
	public String getEngine() {
		return engine;
	}

	@Override
	public void setEngine(String engine) {
		this.engine = engine;
	}
}
