package android.news.com.yapplication.picasso;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Created by yy10017 on 2016/8/23.
 *
 */

public class Picasso {

    private Context mContext;
    private int mReplaceViewId;
    private static Picasso singleInstance = null;

    private Picasso(Context context){
        this.mContext = context;
    }

    public static synchronized Picasso with(Context context){
        if (context == null){
            throw new IllegalArgumentException("context == null!");
        }
        if (singleInstance == null){
            singleInstance = new Picasso(context);
        }
        return singleInstance;
    }

    public RequestCreator load(String path){
        //download image
        return this.load(Uri.parse(path));
    }

    public RequestCreator load(@Nullable Uri uri) {
        return new RequestCreator(this, uri, 0);
    }

    public void into(ImageView view){
        //下载成功
//        view.setImageResource();
        //下载失败
        view.setImageResource(mReplaceViewId);
    }

    public Picasso replaceImage(int replaceViewId) {
        this.mReplaceViewId = replaceViewId;
        return this;
    }
}
