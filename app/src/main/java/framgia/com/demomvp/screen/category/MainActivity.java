package framgia.com.demomvp.screen.category;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import framgia.com.demomvp.R;
import framgia.com.demomvp.data.model.Category;
import framgia.com.demomvp.data.repository.CategoryRepository;
import framgia.com.demomvp.data.source.remote.RemoteDataSource;
import framgia.com.demomvp.screen.base.BaseActivity;

public class MainActivity extends BaseActivity implements CategoryContract.View {
    private static final String TAG = "mainactivity";
    private RecyclerView mRecyclerCategory;
    private CategoryContract.Presenter mCategoryPresenter;
    private ProgressBar mProgressMain;
    private ArrayList<Category> mCategories;
    private CategoryAdapter mCategoryAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponents() {
        mRecyclerCategory = findViewById(R.id.recycler_category);
        mProgressMain = findViewById(R.id.progress_main);
        mCategories = new ArrayList<>();
        mCategoryAdapter = new CategoryAdapter(this, mCategories);
        mRecyclerCategory.setAdapter(mCategoryAdapter);
        mRecyclerCategory.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        RemoteDataSource remoteDataSource = new RemoteDataSource();
        CategoryRepository categoryRepository = new CategoryRepository(remoteDataSource);
        mCategoryPresenter = new CategoryPresenter(categoryRepository);
        mCategoryPresenter.setView(this);
        loadData();
    }

    private void loadData() {
        mCategoryPresenter.getCategories();
    }

    @Override
    public void onGetDataSuccess(ArrayList<Category> data) {
        mCategories.addAll(data);
        mCategoryAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgressBar() {
        mProgressMain.setVisibility(View.GONE);
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
