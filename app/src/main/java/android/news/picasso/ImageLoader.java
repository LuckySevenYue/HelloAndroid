package android.news.picasso;

import android.content.Context;
import android.news.com.yapplication.R;
import android.news.base.HelloApplication;
import android.text.TextUtils;
import android.widget.ImageView;

/**
 * Created by yy10017 on 2016/8/23.
 * 下载图片 处理 展示
 */

public class ImageLoader {

    private static final int DEFAULT_VIEW_ID = -1;//无默认图

    private Context mContext;
    private static ImageLoader instance = null;

    private ImageLoader(Context context){
        this.mContext = context.getApplicationContext();
    }

    public static synchronized ImageLoader getInstance(){
        if (instance == null){
            instance = new ImageLoader(HelloApplication.getInstance());
        }
        return instance;
    }

    public void display(String imageUrl, ImageView imageView, PicCallback callback){
        display(imageUrl, imageView, DEFAULT_VIEW_ID, callback);
    }

    private void display(String imageUrl, ImageView imageView, int replaceViewId, PicCallback callback) {
        if (DEFAULT_VIEW_ID == replaceViewId) {
            replaceViewId = R.drawable.ic_launcher;
        }
        if (TextUtils.isEmpty(imageUrl)){
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(replaceViewId);
        } else {
            Picasso.with(mContext).load(imageUrl).replaceImage(replaceViewId).into(imageView, callback);
        }

    }
}
