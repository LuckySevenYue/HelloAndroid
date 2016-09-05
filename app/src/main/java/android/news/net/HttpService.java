package android.news.net;

import android.content.Context;

/**
 * Created by yy10017 on 2016/9/5.
 *
 */

public class HttpService {

    private Context mContext;

    public HttpService(Context context){
        mContext = context;
    }

    public String sendRequest(Requester requester){
        return requester.key();
    }
}
