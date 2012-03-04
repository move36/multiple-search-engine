package org.move36.searchEngine.search.bing;

import java.util.List;

/**
 * Class that defines the response obteined by a search with the bing web search
 * API
 * 
 * @author javiersevilla
 * 
 */
public class BingResponse {

	private SearchResponse SearchResponse;

	public SearchResponse getSearchResponse() {
		return SearchResponse;
	}

	public void setSearchResponse(SearchResponse searchResponse) {
		SearchResponse = searchResponse;
	}

	public String toString() {
		return "SearchResponse[" + SearchResponse + "]";
	}

	static class SearchResponse {
		private Web Web;

		public Web getWeb() {
			return Web;
		}

		public void setWeb(Web Web) {
			this.Web = Web;
		}
	}

	static class Web {
		private List<BingResult> Results;

		public List<BingResult> getResults() {
			return Results;
		}

		public void setResults(List<BingResult> Results) {
			this.Results = Results;
		}

		public String toString() {
			return "Results[" + Results + "]";
		}
	}
}
