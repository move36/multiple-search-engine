package org.move36.searchEngine.search.google;

import java.util.List;

/**
 * 
 * Class that defines the response obteined by a search with the google web
 * search API
 * 
 * @author javiersevilla
 * 
 */
public class GoogleResponse {

	private ResponseData responseData;

	public ResponseData getResponseData() {
		return responseData;
	}

	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
	}

	public String toString() {
		return "ResponseData[" + responseData + "]";
	}

	static class ResponseData {
		private List<GoogleResult> results;

		public List<GoogleResult> getResults() {
			return results;
		}

		public void setResults(List<GoogleResult> results) {
			this.results = results;
		}

		public String toString() {
			return "Results[" + results + "]";
		}
	}
}
