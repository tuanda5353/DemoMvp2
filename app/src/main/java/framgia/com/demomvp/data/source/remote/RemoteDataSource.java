package framgia.com.demomvp.data.source.remote;

import java.util.ArrayList;

import framgia.com.demomvp.data.model.Category;
import framgia.com.demomvp.data.source.CallBack;
import framgia.com.demomvp.data.source.CategoryDataSource;
import framgia.com.demomvp.untils.Constants;

public class RemoteDataSource implements CategoryDataSource.RemoteDataSource {
    private void getCategoriesFromApi(CallBack<ArrayList<Category>> callBack) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.Api.BASE_URL)
                .append(Constants.Api.LIST_CATEGORY);
        String url = stringBuilder.toString();
        new CategoryRemoteAsyncTask(callBack).execute(url);
    }

    @Override
    public void getCategories(CallBack<ArrayList<Category>> callBack) {
        getCategoriesFromApi(callBack);
    }
}
