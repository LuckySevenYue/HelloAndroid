package android.news.com.yapplication.net;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by yy10017 on 2016/8/23.
 * 请求数据
 */

public class BaseRequest {

    private String mUrl;
    private static final String PIC_URL = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png";
    private static OkHttpClient mOkHttpClient;

    public BaseRequest(String url){
        this.mUrl = url;
        if (mOkHttpClient == null){
            mOkHttpClient = new OkHttpClient();
        }
    }

    public String doRequest(final android.news.com.yapplication.net.Callback callback){
        Request request = new Request.Builder()
                .url(PIC_URL)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                callback.onFail(request.body());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                callback.onSuccess(response);
            }
        });
        return UUID.randomUUID().toString();
    }

}
