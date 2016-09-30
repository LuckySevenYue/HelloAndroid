package android.news.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.news.test.FullScreenActivity;
import android.view.View;

import java.util.Random;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.DKGRAY;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.LTGRAY;

/**
 * Created by yue10017 on 2016/9/27.
 *
 */

public class CustomView extends View {

    private Paint paint;

    int colors[] = { Color.BLACK
            ,Color.DKGRAY
            ,Color.GRAY
            ,Color.LTGRAY
            ,Color.RED
            ,Color.GREEN
            ,Color.BLUE
            ,Color.YELLOW
            ,Color.CYAN
            ,Color.MAGENTA
            ,Color.TRANSPARENT };

    float x; float y;
    int radius;

    public CustomView(Context context, float x, float y, int radius) {
        super(context);

        this.x = x;
        this.y = y;
        this.radius = radius;

        paint = new Paint(); //设置一个笔刷大小是3的黄色的画笔

        paint.setColor(colors[new Random().nextInt(colors.length)]);

        paint.setStrokeJoin(Paint.Join.ROUND);

        paint.setStrokeCap(Paint.Cap.ROUND);

        paint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, y, radius, paint);//圆心 半径
    }
}
