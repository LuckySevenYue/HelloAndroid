package android.news.com.yapplication.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.news.com.yapplication.net.BaseRequest;
import android.news.com.yapplication.net.Callback;
import android.news.com.yapplication.util.FileUtils;
import android.news.com.yapplication.util.ICallback;
import android.news.com.yapplication.util.LogCat;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.File;
import java.io.IOException;

/**
 * Created by yy10017 on 2016/8/23.
 * 下载图片请求
 */

public class RequestCreator {

    private Bitmap mBitmap;
    private int mReplaceViewId;
    private String mUrl;
    private Handler mHandler;
    private ImageView view;

    //uri 分为 file 和 net。
    RequestCreator(String url) {
        this.mUrl = url;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public RequestCreator replaceImage(int replaceViewId) {
        this.mReplaceViewId = replaceViewId;
        return this;
    }

    public void into(ImageView imageView, PicCallback callback) {
        this.view = imageView;
        requestBitmap(callback);
    }

    private void requestBitmap(final PicCallback callback) {
        new BaseRequest(mUrl).doRequest(new Callback() {
            @Override
            public void onSuccess(final Response response) {
                callback.onSuccess();
                if (response.code() == 200){
                    try {
                        byte[] data = response.body().bytes();
                        final Bitmap bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                view.setImageBitmap(bitmap);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    transformStream(response.body());
                }
            }

            @Override
            public void onFail(RequestBody body) {
                callback.onFail();
            }
        });
    }

    private void transformStream(ResponseBody body) {
        try {
            final byte[] buf = body.bytes();

            FileUtils.makeFile(buf, new ICallback() {
                @Override
                public void doFile(final File file) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            view.setImageURI(Uri.fromFile(file));
                        }
                    });
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
