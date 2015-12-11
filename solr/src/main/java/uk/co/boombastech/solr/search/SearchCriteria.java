package uk.co.boombastech.solr.search;

import com.google.common.collect.Multimap;

import static com.google.common.collect.ArrayListMultimap.create;

public class SearchCriteria<T> {

	private final Multimap<String, String> searchCriteria;
	private String sortByField;

	public SearchCriteria() {
		searchCriteria = create();
	}

	public SearchCriteria<T> withFacet(String facet, String value) {
		searchCriteria.put(facet, value);
		return this;
	}

	public Multimap<String, String> getSearchCriteria() {
		return searchCriteria;
	}

	public String getSortByField() {
		return sortByField;
	}

	public void setSortByField(String sortByField) {
		this.sortByField = sortByField;
	}
}