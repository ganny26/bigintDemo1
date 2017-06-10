package demo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class APIClient {

    public String getHttp(String requestUrl) throws  IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(requestUrl);
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        String resultResponse = EntityUtils.toString(entity);
        return resultResponse;
    }

    public String getHttp2(String requestUrl)  throws  IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(requestUrl)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}