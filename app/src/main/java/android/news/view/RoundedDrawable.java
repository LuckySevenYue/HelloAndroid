package android.news.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by yue10017 on 2016/9/27.
 *
 */

public class RoundedDrawable extends Drawable {

    private float radius = 0;
    private int mBitmapWidth, mBitmapHeight;

    private Paint mPaint = new Paint();
    private RectF mRectF = new RectF();

    public RoundedDrawable(Bitmap bitmap){
        mBitmapWidth = bitmap.getWidth();
        mBitmapHeight = bitmap.getHeight();

        mRectF.set(0, 0, mBitmapWidth, mBitmapHeight);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public RoundedDrawable setRadius(float radius){
        this.radius = Math.max(0,radius);
        return this;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(mRectF, radius, radius, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    public static Drawable fromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new RoundedDrawable(bitmap);
        } else {
            return null;
        }
    }

    public static Drawable fromDrawable(Drawable drawable) {
        if (drawable instanceof RoundedDrawable){
            return drawable;
        }
        return null;
    }
}
