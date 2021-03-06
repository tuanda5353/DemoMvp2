package framgia.com.demomvp.untils;

public class Constants {
    public class JsonKey {
        public static final String CAT_ID = "cid";
        public static final String CATEGORY_NAME = "category_name";
        public static final String CATEGORY_IMAGE = "category_image";
        public static final String CATEGORY_IMAGE_THUMB = "category_image_thumb";
        public static final String TOTAL_WALLPAPER = "total_wallpaper";
        public static final String ARRAY = "HD_WALLPAPER";
    }

    public class Api {
        public static final int TIME_OUT = 15000;
        public static final String METHOD_GET = "GET";
        public static final String REQUEST_PROPERTY_KEY = "Content-length";
        public static final String REQUEST_PROPERTY_VALUE = "0";
        public static final String BASE_URL = "http://tapetee.com";
        public static final String LIST_CATEGORY = "/api.php?cat_list";
    }
    public class Picasso{
        public static final int RESIZE =300;
    }
}
