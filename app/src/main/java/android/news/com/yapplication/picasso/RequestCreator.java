package android.news.com.yapplication.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.news.com.yapplication.net.BaseRequest;
import android.news.com.yapplication.net.Callback;
import android.news.com.yapplication.util.FileUtils;
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
    private Uri mUri;
    private Handler mHandler;

    //uri 分为 file 和 net。
    RequestCreator(Uri uri) {
        this.mUri = uri;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public RequestCreator replaceImage(int replaceViewId) {
        this.mReplaceViewId = replaceViewId;
        return this;
    }

    public void into(ImageView imageView, PicCallback callback){
        requestBitmap();
        if (mBitmap != null){
            callback.onSuccess();
            imageView.setImageBitmap(mBitmap);
        } else {
            imageView.setImageResource(mReplaceViewId);
            callback.onFail();
        }
    }

    private void requestBitmap() {
        LogCat.e(getClass().getSimpleName(),"mUri.getPath() = "+mUri.getPath());
        new BaseRequest(mUri.getPath()).doRequest(new Callback() {
            @Override
            public void onSuccess(final Response response) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            transformStream(response.body());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void onFail(RequestBody body) {

            }
        });
    }

    private Bitmap transformStream(ResponseBody body) throws IOException {
        if (body == null){
            return null;
        }
        File file = FileUtils.makeFile(body.byteStream());
        mBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        return mBitmap;
    }
}
