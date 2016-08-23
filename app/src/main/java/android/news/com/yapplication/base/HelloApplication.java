package android.news.com.yapplication.base;

import android.app.Application;

/**
 * Created by yy10017 on 2016/8/23.
 * application
 */

public class HelloApplication extends Application {

    protected static HelloApplication mInstance;

    @Override
    public void onCreate() {
        mInstance = this;
    }

    public static HelloApplication getInstance(){
        return mInstance;
    }
}
