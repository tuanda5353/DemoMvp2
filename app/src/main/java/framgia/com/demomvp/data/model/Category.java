package framgia.com.demomvp.data.model;

import org.json.JSONException;
import org.json.JSONObject;

import framgia.com.demomvp.untils.Constants;

public class Category {
    private int mId;
    private String mName;
    private String mImage;
    private String mImageThump;
    private int mTotalWallpaper;

    public Category(int id, String name, String image, String imageThump, int totalWallpaper) {
        mId = id;
        mName = name;
        mImage = image;
        mImageThump = imageThump;
        mTotalWallpaper = totalWallpaper;
    }

    public Category(JSONObject jsonObject) throws JSONException{
        this.mId = jsonObject.getInt(Constants.JsonKey.CAT_ID);
        this.mName = jsonObject.getString(Constants.JsonKey.CATEGORY_NAME);
        this.mImage = jsonObject.getString(Constants.JsonKey.CATEGORY_IMAGE);
        this.mImageThump = jsonObject.getString(Constants.JsonKey.CATEGORY_IMAGE_THUMB);
        this.mTotalWallpaper = jsonObject.getInt(Constants.JsonKey.TOTAL_WALLPAPER);

    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getImageThump() {
        return mImageThump;
    }

    public void setImageThump(String imageThump) {
        mImageThump = imageThump;
    }

    public int getTotalWallpaper() {
        return mTotalWallpaper;
    }

    public void setTotalWallpaper(int totalWallpaper) {
        mTotalWallpaper = totalWallpaper;
    }
}
