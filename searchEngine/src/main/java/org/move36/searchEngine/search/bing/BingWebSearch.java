package org.move36.searchEngine.search.bing;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.move36.searchEngine.search.WebSearchEngine;
import org.move36.searchEngine.search.WebSearchResult;

import com.google.gson.Gson;

/**
 * Implementation of WebSearchEngine with the Bing web search API
 * 
 * @author javiersevilla
 * 
 */
public class BingWebSearch implements WebSearchEngine {

	public static final String NAME = "Bing";
	private static final String BING_URL = "http://api.search.live.net/json.aspx?sources=web";
	private static final String CHARSET = "UTF-8";
	private String app;

	@Override
	public String getEngineName() {
		return BingWebSearch.NAME;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	@Override
	public List<WebSearchResult> search(String term) {

		List<BingResult> results = null;
		try {

			URL url = new URL(generateUrl(term));
			Reader reader = new InputStreamReader(url.openStream(), BingWebSearch.CHARSET);
			BingResponse jsonResults = new Gson().fromJson(reader, BingResponse.class);
			results = jsonResults.getSearchResponse().getWeb().getResults();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<WebSearchResult> bingResults = new ArrayList<WebSearchResult>();
		if (results != null) {
			bingResults.addAll(results);
		}
		return bingResults;
	}

	/**
	 * Method that constructs a URL with the params needed
	 * 
	 * @param term
	 *          , the term to search
	 * @return the entire url to use
	 * @throws UnsupportedEncodingException
	 */
	private String generateUrl(String term) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		sb.append(BingWebSearch.BING_URL);
		sb.append("&Appid=");
		sb.append(this.app);
		sb.append("&query=");
		sb.append(URLEncoder.encode(term, BingWebSearch.CHARSET));
		return sb.toString();
	}
}
