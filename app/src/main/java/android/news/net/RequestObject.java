package android.news.net;

import java.io.Serializable;

/**
 * Created by yy10017 on 2016/9/5.
 * 请求体
 */

public class RequestObject extends Requester implements Serializable{

    private String url;
    private Object obj;

    public RequestObject(String url, Object obj){
        this.url = url;
        this.obj = obj;
    }

}
