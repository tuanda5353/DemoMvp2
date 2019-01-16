package framgia.com.demomvp.screen.category;

import java.util.ArrayList;

import framgia.com.demomvp.data.model.Category;
import framgia.com.demomvp.screen.base.BasePresenter;

public class CategoryContract {
    public interface View{
        void onGetDataSuccess(ArrayList<Category> data);
        void hideProgressBar();
        void showToast(String string);
    }
    public interface Presenter extends BasePresenter<View> {
        void getCategories();
    }
}
