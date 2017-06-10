package search;


import demo.APIClient;
import demo.DiscoverObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by serajam on 6/10/2017.
 */
public class DiscoverAPI {

    private static final String API_URL = "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=c79895ea6c454b50e1c7ce72f887f24c";
    private static final String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w300";

    public static void main(String[] args) throws IOException {
        APIClient apiClient = new APIClient();
        ArrayList<DiscoverObject> discoverList = new ArrayList<DiscoverObject>();
        String discoverResponse = apiClient.getHttp2(API_URL);
        JSONObject jsonObject = new JSONObject(discoverResponse);
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");

        for (Object obj : jsonArray) {
            DiscoverObject discoverObject = new DiscoverObject();
            JSONObject resultObject = (JSONObject) obj;
            String posterPathUrl = POSTER_BASE_URL +  resultObject.get("poster_path");
            discoverObject.setMovieTitle((String) resultObject.get("original_title"));
            discoverObject.setReleaseDate((String) resultObject.get("release_date"));
            discoverObject.setPosterPath(posterPathUrl);
            discoverObject.setMovieRating(String.valueOf(resultObject.get("vote_average")));
            discoverList.add(discoverObject);
        }
    }


}
