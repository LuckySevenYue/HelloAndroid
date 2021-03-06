package android.news.base;

import android.news.net.HttpService;
import android.news.net.Requester;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by yy10017 on 2016/8/23.
 * base
 */

public class BaseActivity extends FragmentActivity implements View.OnClickListener{

    private HttpService mHttpService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHttpService = new HttpService(this);
    }

    @SuppressWarnings("unchecked")
    public final <V extends View> V getView(int id) {
        try {
            return (V) findViewById(id);
        } catch (ClassCastException ex) {
            throw ex;
        }
    }

    @Override
    public void onClick(View v) {

    }

    public String sendRequest(Requester obj){
        return mHttpService.sendRequest(obj);
    }
}
