package android.news.com.yapplication.net;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by yy10017 on 2016/8/23.
 * 响应接口
 */
public interface Callback {

    void onSuccess(Response response);

    void onFail(RequestBody body);
}