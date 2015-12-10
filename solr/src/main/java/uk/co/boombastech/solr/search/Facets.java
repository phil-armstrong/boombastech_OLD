package uk.co.boombastech.solr.search;

import java.util.Iterator;
import java.util.List;

public class Facets implements Iterable<Facet> {

	private final List<Facet> facets;

	public Facets(List<Facet> facets) {
		this.facets = facets;
	}

	@Override
	public Iterator<Facet> iterator() {
		return facets.iterator();
	}
}