package framgia.com.demomvp.data.source.remote;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import framgia.com.demomvp.data.model.Category;
import framgia.com.demomvp.untils.Constants;


public class CategoryDataApi {
    private static final String TAG = "fetchdatafromapi";
    private static final int STATUS = 200;

    public static String getJsonStringFromApi(String url) throws IOException {
        HttpURLConnection httpURLConnection = null;
        httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        httpURLConnection.setRequestMethod(Constants.Api.METHOD_GET);
        httpURLConnection.setRequestProperty(Constants.Api.REQUEST_PROPERTY_KEY, Constants.Api.REQUEST_PROPERTY_VALUE);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setConnectTimeout(Constants.Api.TIME_OUT);
        httpURLConnection.setReadTimeout(Constants.Api.TIME_OUT);
        httpURLConnection.connect();
        int status = httpURLConnection.getResponseCode();
        if (status == STATUS) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            bufferedReader.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString();
        }
        return null;
    }

    public static ArrayList<Category> convertJsonToArrayCategory(String json) throws JSONException {
        ArrayList<Category> categories = new ArrayList<>();
        JSONObject jsonObject = null;
        jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray(Constants.JsonKey.ARRAY);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObjectCategory = jsonArray.getJSONObject(i);
            Category category = new Category(jsonObjectCategory);
            categories.add(category);
        }
        return categories;
    }
}
