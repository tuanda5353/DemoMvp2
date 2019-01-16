package framgia.com.demomvp.data.source;

import java.util.ArrayList;
import framgia.com.demomvp.data.model.Category;

public interface CategoryDataSource {
    interface RemoteDataSource {
        void getCategories(CallBack<ArrayList<Category>> callBack);
    }

    interface LocalDataSource {
    }
}
