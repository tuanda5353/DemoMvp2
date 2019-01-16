package framgia.com.demomvp.screen.category;

import java.util.ArrayList;

import framgia.com.demomvp.data.model.Category;
import framgia.com.demomvp.data.repository.CategoryRepository;
import framgia.com.demomvp.data.source.CallBack;

public class CategoryPresenter implements CategoryContract.Presenter {
    private CategoryContract.View mView;
    private CategoryRepository mCategoryRepository;

    public CategoryPresenter(CategoryRepository categoryRepository) {
        mCategoryRepository = categoryRepository;
    }

    @Override
    public void setView(CategoryContract.View view) {
        this.mView = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void getCategories() {
        mCategoryRepository.getCategories(new CallBack<ArrayList<Category>>() {
            @Override
            public void getDataSuccess(ArrayList<Category> data) {
                mView.onGetDataSuccess(data);
                mView.hideProgressBar();
            }

            @Override
            public void getDataFailure(Exception e) {
                mView.hideProgressBar();
                mView.showToast(e.toString());
            }
        });
    }
}
