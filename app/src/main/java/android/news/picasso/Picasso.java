package android.news.picasso;

import android.content.Context;

/**
 * Created by yy10017 on 2016/8/23.
 *
 */

public class Picasso {

    private Context mContext;
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
        return new RequestCreator(path);
    }

}
