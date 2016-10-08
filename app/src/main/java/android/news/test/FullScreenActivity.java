package android.news.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.news.R;
import android.news.base.BaseActivity;
import android.news.util.LogCat;
import android.news.view.CustomView;
import android.news.view.RoundedImageView;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by yy10017 on 2016/9/14.
 *
 */

public class FullScreenActivity extends BaseActivity {

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        View view = new CustomView(this);

        setContentView(R.layout.activity_main);
        layout = (RelativeLayout) findViewById(R.id.rl_full);
        LogCat.e("density", "density = " + getResources().getDisplayMetrics().density);
//        tv.post(new Runnable() {
//            @Override
//            public void run() {
//                LogCat.e("tv", "getX = " + tv.getX());
//                LogCat.e("tv", "getY = " + tv.getY());
//
//                LogCat.e("tv", "getLeft = " + tv.getLeft());
//                LogCat.e("tv", "getRight = " + tv.getRight());
//                LogCat.e("tv", "getWidth = " + tv.getWidth());
//
//                LogCat.e("tv", "getTop = " + tv.getTop());
//                LogCat.e("tv", "getBottom = " + tv.getBottom());
//                LogCat.e("tv", "getHeight = " + tv.getHeight());
//
//                LogCat.e("tv", "getTextSize = " + tv.getTextSize());
//            }
//        });

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        LogCat.e("tv", "getX = " + event.getX());
                        LogCat.e("tv", "getY = " + event.getY());
                        draw(event);
                        break;

                    case MotionEvent.ACTION_UP:
                        break;

                    case MotionEvent.ACTION_MOVE:
                        break;
                }
                return false;
            }
        });

        /**
         * 设置自定义View RoundedImageView
         Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_two);
         RoundedImageView view = new RoundedImageView(this, bitmap);
         setContentView(view);
         */

        /**
         * 通过 getRoundedCornerBitmap 方法获取定制的圆角 Bitmap;
         setContentView(R.layout.full_layout);
         ImageView imageView = getView(R.id.iv_round_show);
         imageView.setImageBitmap(getRoundedCornerBitmap(bitmap, 30.0f));
         */

    }

    /**
     * draw bit bit
     * @param event 获取坐标
     */
    private void draw(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        CustomView view = new CustomView(this, x, y, 30);
        layout.addView(view);
    }














    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx){
        Bitmap output = null;
        try {
            if(bitmap == null)
                return null;
            output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            final RectF rectF = new RectF(rect);

            canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rectF, paint);
        } catch (OutOfMemoryError e) {
            System.gc();
            output = null;
        }
        return output;
    }
}
