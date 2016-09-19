package android.news.test.faceinterface;

/**
 * Created by yy10017 on 2016/9/19.
 * 人体颜色
 */

public enum Color implements IColor{

    WHITE(0x000000, true),
    HALF_WHITE(0x000000, false),
    YELLOW(0x111111, true),
    HALF_YELLOW(0x111111, false),
    BLACK(0x222222, true),
    HALF_BLACK(0x222222, false);

    private int color;
    private boolean isLocal;

    Color(int color, boolean isLocal){
        this.color = color;
        this.isLocal = isLocal;
    }

    @Override
    public int color() {
        return color;
    }

    @Override
    public boolean isLocal() {
        return isLocal;
    }
}
