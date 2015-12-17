package uk.co.boombastech.http;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Request {
	String getUrl();
	HttpMethod getMethod();
	Parameters getQueryParameters();
	Collection<String> getQueryParameter(String parameter);
	Parameters getPostParameters();
	Collection<String> getPostParameter(String parameter);
	Optional<String> getHeader(Header header);
	Optional<String> getCookie(Cookie cookie);
}