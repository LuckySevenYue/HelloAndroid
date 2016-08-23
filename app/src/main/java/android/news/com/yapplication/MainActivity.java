package android.news.com.yapplication;

import android.app.Activity;
import android.news.com.yapplication.base.BaseActivity;
import android.news.com.yapplication.picasso.ImageLoader;
import android.news.com.yapplication.picasso.PicCallback;
import android.news.com.yapplication.util.LogCat;
import android.news.com.yapplication.util.Uikit;
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
import java.io.InputStream;

public class MainActivity extends BaseActivity {

    private static final String PIC_URL = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Request req = new Request.Builder()
//        .url(PIC_URL).
//            get().build();
//
//        OkHttpClient client = new OkHttpClient();
//        client.newCall(req).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//                Log.e("dd","ddaaa");
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                byte[] buf = response.body().bytes();
//                File f = new File("/mnt/sdcard/A.png");
//                FileOutputStream fos = new FileOutputStream(f);
//                fos.write(buf);
//                fos.flush();
//
//
//                Log.e("ddddd","dd");
//            }
//        });

        ImageView view = getView(R.id.iv_show);

        ImageLoader.getInstance().display(PIC_URL, view, new PicCallback() {
            @Override
            public void onSuccess() {
                LogCat.e("MainActivity", "onSuccess()");
            }

            @Override
            public void onFail() {
                LogCat.e("MainActivity", "onFail()");
            }
        });
    }
}
