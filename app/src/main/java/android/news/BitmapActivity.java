package android.news;

import android.app.Activity;
import android.news.base.BaseActivity;
import android.news.picasso.ImageLoader;
import android.news.picasso.PicCallback;
import android.news.util.Uikit;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yy10017 on 2016/8/26.
 * 图片下载demo
 */

public class BitmapActivity extends BaseActivity {

    private static final String PIC_URL = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png";
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.news.com.yapplication.R.layout.activity_main);
        mActivity = this;
        Request req = new Request.Builder()
                .url(PIC_URL).
                        get().build();

        OkHttpClient client = new OkHttpClient();
        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e("dd","ddaaa");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                byte[] buf = response.body().bytes();
                File f = new File("/mnt/sdcard/A.png");
                FileOutputStream fos = new FileOutputStream(f);
                fos.write(buf);
                fos.flush();


                Log.e("ddddd","dd");
            }
        });

        ImageView view = getView(android.news.com.yapplication.R.id.iv_show);

        ImageLoader.getInstance().display(PIC_URL, view, new PicCallback() {
            @Override
            public void onSuccess() {
                Uikit.showToast(mActivity,"MainActivity_onSuccess()");
            }

            @Override
            public void onFail() {
                Uikit.showToast(mActivity,"MainActivity_onFail()");
            }
        });
    }
}
