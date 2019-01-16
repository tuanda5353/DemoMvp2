package framgia.com.demomvp.screen.category;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import framgia.com.demomvp.R;
import framgia.com.demomvp.data.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Category> mCategories;

    public CategoryAdapter(Context context, ArrayList<Category> categories) {
        mContext = context;
        mCategories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_category,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Category category = mCategories.get(i);
        viewHolder.mTextTotalCategory.setText(String.valueOf(category.getTotalWallpaper()));
        Picasso.get()
                .load(category.getId())
                .into(viewHolder.mImageCategory);
    }

    @Override
    public int getItemCount() {
        return mCategories.isEmpty() ? 0 : mCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageCategory;
        private TextView mTextView;
        private TextView mTextTotalCategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageCategory = itemView.findViewById(R.id.image_category);
            mTextView = itemView.findViewById(R.id.textView);
            mTextTotalCategory = itemView.findViewById(R.id.text_total_category);
        }
    }
}
