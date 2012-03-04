package org.move36.searchEngine.search;

/**
 * Result obtained after a web search
 * 
 * @author javiersevilla
 * 
 */
public interface WebSearchResult {
	/**
	 * get method of the title of the web
	 * 
	 * @return the title of the web
	 */
	String getTitle();

	/**
	 * sets the title of the web
	 * 
	 * @param title
	 */
	void setTitle(String title);

	/**
	 * gets the description of the web
	 * 
	 * @return description of the web
	 */
	String getDescription();

	/**
	 * sets the description of the web
	 * 
	 * @param description
	 *          of the web
	 */
	void setDescription(String description);

	/**
	 * gets the url of the web
	 * 
	 * @return url
	 */
	String getUrl();

	/**
	 * set the url of the web
	 * 
	 * @param url
	 */
	void setUrl(String url);

	/**
	 * get the name of the engine who retrieve this result
	 * 
	 * @return
	 */
	String getEngine();

	/**
	 * set the name of the engine who retrieve this result
	 * 
	 * @param engine
	 */
	void setEngine(String engine);

}
