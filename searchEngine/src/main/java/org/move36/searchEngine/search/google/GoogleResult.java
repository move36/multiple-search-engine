package org.move36.searchEngine.search.google;

import org.move36.searchEngine.search.WebSearchResult;

/**
 * 
 * Implementation of WebSearchResult for BingWebSearch results
 * 
 * @author javiersevilla
 * 
 */
public class GoogleResult implements WebSearchResult {

	private String title;
	private String url;
	private String engine;
	private String content;

	public GoogleResult() {
		super();
		this.engine = GoogleWebSearch.NAME;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getDescription() {
		return content;
	}

	@Override
	public void setDescription(String description) {
		this.content = description;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getEngine() {
		return engine;
	}

	@Override
	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
