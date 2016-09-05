package android.news.net;

import java.util.UUID;

/**
 * Created by yy10017 on 2016/9/5.
 *
 */

public abstract class Requester {

    private String mKey;

    public Requester(){
        this.mKey = UUID.randomUUID().toString();
    }

    public String key(){
        return mKey;
    }
}
