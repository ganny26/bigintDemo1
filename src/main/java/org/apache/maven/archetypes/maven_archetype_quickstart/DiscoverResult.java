package org.apache.maven.archetypes.maven_archetype_quickstart;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;

public class DiscoverResult {
	private static final String API_URL = "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=c79895ea6c454b50e1c7ce72f887f24c";
	private static final String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w300";
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		APIClient apiClient = new APIClient();	
		ArrayList<DiscoverObject> discoverList = new ArrayList<DiscoverObject>();
		String discoverResponse = apiClient.getHttp(API_URL);
		JSONObject jsonObject = new JSONObject(discoverResponse);
		JSONArray jsonArray = (JSONArray) jsonObject.get("results");
		
		for (Object obj : jsonArray) {
			DiscoverObject discoverObject = new DiscoverObject();	
			JSONObject resultObject = (JSONObject) obj;
			String posterPathUrl = POSTER_BASE_URL + (String) resultObject.get("poster_path");
			discoverObject.setMovieTitle((String) resultObject.get("original_title"));
			discoverObject.setReleaseDate((String) resultObject.get("release_date"));
			discoverObject.setPosterPath(posterPathUrl);
			discoverObject.setMovieRating((Double) resultObject.get("vote_average"));
			discoverList.add(discoverObject);
		}
	}
}
