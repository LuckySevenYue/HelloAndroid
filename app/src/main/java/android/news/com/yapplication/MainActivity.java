package android.news.com.yapplication;

import android.app.Activity;
import android.news.com.yapplication.base.BaseActivity;
import android.news.com.yapplication.picasso.ImageLoader;
import android.news.com.yapplication.picasso.PicCallback;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {

    private static final String PIC_URL = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView view = getView(R.id.iv_show);

        ImageLoader.getInstance().display(PIC_URL, view, new PicCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFail() {

            }
        });
    }
}
