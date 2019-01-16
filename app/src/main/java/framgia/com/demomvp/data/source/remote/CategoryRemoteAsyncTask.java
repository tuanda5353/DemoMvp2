package framgia.com.demomvp.data.source.remote;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import framgia.com.demomvp.data.model.Category;
import framgia.com.demomvp.data.source.CallBack;

public class CategoryRemoteAsyncTask extends AsyncTask<String, String, ArrayList<Category>> {
    private CallBack<ArrayList<Category>> mCallBack;
    private Exception mException;

    public CategoryRemoteAsyncTask(CallBack<ArrayList<Category>> mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    protected ArrayList<Category> doInBackground(String... strings) {
        ArrayList<Category> categories = new ArrayList<>();
        String json = null;
        try {
            json = CategoryDataApi.getJsonStringFromApi(strings[0]);
            if (json != null) categories = CategoryDataApi.convertJsonToArrayCategory(json);
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return categories;
    }

    @Override
    protected void onPostExecute(ArrayList<Category> categories) {
        super.onPostExecute(categories);
        if (mException == null) {
            mCallBack.getDataSuccess(categories);
        } else {
            mCallBack.getDataFailure(mException);
        }
    }
}
