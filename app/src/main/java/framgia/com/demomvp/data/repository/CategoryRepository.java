package framgia.com.demomvp.data.repository;


import java.util.ArrayList;

import framgia.com.demomvp.data.model.Category;
import framgia.com.demomvp.data.source.CallBack;
import framgia.com.demomvp.data.source.CategoryDataSource;

public class CategoryRepository implements CategoryDataSource.RemoteDataSource,CategoryDataSource.LocalDataSource {
    private CategoryDataSource.RemoteDataSource mRemoteDataSource;

    public CategoryRepository(CategoryDataSource.RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getCategories(CallBack<ArrayList<Category>> callBack) {
        mRemoteDataSource.getCategories(callBack);
    }
}
