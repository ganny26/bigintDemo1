package org.apache.maven.archetypes.maven_archetype_quickstart;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class APIClient {

	public String getHttp(String requestUrl) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(requestUrl);
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		String resultResponse = EntityUtils.toString(entity);
		return resultResponse;
	}
}
