package org.move36.searchEngine.search.google;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.move36.searchEngine.search.WebSearchEngine;
import org.move36.searchEngine.search.WebSearchResult;

import com.google.gson.Gson;

/**
 * Implementation of WebSearchEngine with the Google web search API
 * 
 * @author javiersevilla
 * 
 */
public class GoogleWebSearch implements WebSearchEngine {

	public static final String NAME = "Google";
	private static final String GOOGLE_URL = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
	private static final String CHARSET = "UTF-8";

	@Override
	public String getEngineName() {
		return GoogleWebSearch.NAME;
	}

	@Override
	public List<WebSearchResult> search(String term) {

		List<GoogleResult> results = null;
		try {
			URL url = new URL(GoogleWebSearch.GOOGLE_URL + URLEncoder.encode(term, GoogleWebSearch.CHARSET));
			Reader reader = new InputStreamReader(url.openStream(), GoogleWebSearch.CHARSET);
			GoogleResponse jsonResults = new Gson().fromJson(reader, GoogleResponse.class);
			results = jsonResults.getResponseData().getResults();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<WebSearchResult> googleResults = new ArrayList<WebSearchResult>();
		if (results != null) {
			googleResults.addAll(results);
		}
		return googleResults;
	}
}
