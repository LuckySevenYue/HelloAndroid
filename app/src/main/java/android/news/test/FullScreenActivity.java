package android.news.test;

import android.app.ActionBar;
import android.graphics.Color;
import android.news.R;
import android.news.base.BaseActivity;
import android.news.util.LogCat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

/**
 * Created by yy10017 on 2016/9/14.
 * 沉浸式
 */

public class FullScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_layout);
        LogCat.e("packageName", "packageName = " + getPackageName());
        if (Build.VERSION.SDK_INT > 21){
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
