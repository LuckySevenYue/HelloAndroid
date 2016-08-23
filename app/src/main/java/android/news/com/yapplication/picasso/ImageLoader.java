package android.news.com.yapplication.picasso;

import android.content.Context;
import android.news.com.yapplication.base.HelloApplication;
import android.news.com.yapplication.util.Uikit;
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
        this.mContext = mContext.getApplicationContext();
    }

    public synchronized ImageLoader getInstance(){
        if (instance == null){
            instance = new ImageLoader(HelloApplication.getInstance());
        }
        return instance;
    }

    public void display(String imageUrl, ImageView imageView){
        display(imageUrl, imageView, DEFAULT_VIEW_ID);
    }

    private void display(String imageUrl, ImageView imageView, int defaultViewId) {
        if (TextUtils.isEmpty(imageUrl)){
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(defaultViewId);
        } else {
            Picasso.with(mContext).load(imageUrl).replaceImage(defaultViewId).into(imageView);
        }

    }
}
