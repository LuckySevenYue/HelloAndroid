package android.news.view;

/**
 * Created by yue10017 on 2016/10/20.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

public class StyleString {
    private Context mContext;
    private String mText;
    private SpannableStringBuilder mBuilder;

    public StyleString(Context context, String text) {
        this.mContext = context;
        this.mText = text == null?"":text;
        this.mBuilder = new SpannableStringBuilder();
        this.mBuilder.append(this.mText);
    }

    public StyleString setForegroundColor(int colorId) {
        if(this.mContext == null) {
            return this;
        } else {
            this.mBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(colorId)), 0, this.mText.length(), 33);
            return this;
        }
    }

    public StyleString setBackgroundColor(int color) {
        if(this.mContext == null) {
            return this;
        } else {
            this.mBuilder.setSpan(new BackgroundColorSpan(this.mContext.getResources().getColor(color)), 0, this.mText.length(), 33);
            return this;
        }
    }

    public StyleString setFontSizePX(int fontSizePX) {
        this.mBuilder.setSpan(new AbsoluteSizeSpan(fontSizePX), 0, this.mText.length(), 33);
        return this;
    }

    public StyleString setFontSize(int dimenSize) {
        if(this.mContext == null) {
            return this;
        } else {
            this.mBuilder.setSpan(new AbsoluteSizeSpan(this.mContext.getResources().getDimensionPixelSize(dimenSize)), 0, this.mText.length(), 33);
            return this;
        }
    }

    public StyleString setFontStyle(int typeFace) {
        this.mBuilder.setSpan(new StyleSpan(typeFace), 0, this.mText.length(), 33);
        return this;
    }

    public StyleString setUnderline() {
        this.mBuilder.setSpan(new UnderlineSpan(), 0, this.mText.length(), 33);
        return this;
    }

    public StyleString setNoUnderline() {
        this.mBuilder.setSpan(new StyleString.NoUnderlineSpan(), 0, this.mText.length(), 33);
        return this;
    }

    public StyleString setClickable(ClickableSpan clickable) {
        this.mBuilder.setSpan(clickable, 0, this.mText.length(), 33);
        return this;
    }

    public StyleString setUri(String uri) {
        this.mBuilder.setSpan(new URLSpan(uri), 0, this.mText.length(), 33);
        return this;
    }

    public StyleString setStrikethrough() {
        this.mBuilder.setSpan(new StrikethroughSpan(), 0, this.mText.length(), 33);
        return this;
    }

    public SpannableStringBuilder toStyleString() {
        return this.mBuilder;
    }

    public class NoUnderlineSpan extends UnderlineSpan {
        public NoUnderlineSpan() {
        }

        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
        }
    }
}
