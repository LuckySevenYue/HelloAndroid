package android.news;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.news.view.StyleString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

public class StringFormatBuilder {
    private SpannableStringBuilder spBuilder = new SpannableStringBuilder();
    private String wholeStr;
    private String highlightStr;
    private int start = 0;
    private int end = 0;
    private static final int DEF_COLOR = -39373;

    public StringFormatBuilder() {
    }

    public StringFormatBuilder(String wholeStr, String highlightStr) {
        this.wholeStr = wholeStr;
        this.highlightStr = highlightStr;
        if(TextUtils.isEmpty(wholeStr)) {
            if(TextUtils.isEmpty(highlightStr)) {
                return;
            }

            this.spBuilder.append(highlightStr);
        } else {
            this.spBuilder.append(wholeStr);
        }

        this.getIndexs();
        this.buildColor(0);
    }

    public StringFormatBuilder append(CharSequence text) {
        this.spBuilder.append(text);
        return this;
    }

    public StringFormatBuilder append(StyleString styleString) {
        this.spBuilder.append(styleString.toStyleString());
        return this;
    }

    public Spanned build() {
        return this.spBuilder;
    }

    public StringFormatBuilder buildColor(int color) {
        if(color == 0) {
            color = -39373;
        }

        ForegroundColorSpan spanColor = new ForegroundColorSpan(color);
        this.spBuilder.setSpan(spanColor, this.start, this.end, 33);
        return this;
    }

    public StringFormatBuilder buildSize(int pixelSize) {
        AbsoluteSizeSpan spanSize = new AbsoluteSizeSpan(pixelSize);
        this.spBuilder.setSpan(spanSize, this.start, this.end, 33);
        return this;
    }

    public StringFormatBuilder buildStyle(int style) {
        if(style > 0) {
            StyleSpan styleSpan = new StyleSpan(style);
            this.spBuilder.setSpan(styleSpan, this.start, this.end, 33);
        }

        return this;
    }

    public SpannableStringBuilder getResult() {
        return this.spBuilder;
    }

    private void getIndexs() {
        if(!TextUtils.isEmpty(this.wholeStr) && !TextUtils.isEmpty(this.highlightStr)) {
            if(!this.wholeStr.contains(this.highlightStr)) {
                return;
            }

            this.start = this.wholeStr.indexOf(this.highlightStr);
            this.end = this.start + this.highlightStr.length();
        } else if(TextUtils.isEmpty(this.wholeStr) && !TextUtils.isEmpty(this.highlightStr)) {
            this.start = 0;
            this.end = this.highlightStr.length();
        }

    }

    public StringFormatBuilder append(String appendStr) {
        if(!TextUtils.isEmpty(appendStr)) {
            this.spBuilder.append(appendStr);
        }

        return this;
    }

    public StringFormatBuilder insert(int position, String insertStr) {
        if(TextUtils.isEmpty(insertStr)) {
            return this;
        } else {
            if(!TextUtils.isEmpty(this.wholeStr)) {
                if(position >= 0 && position <= this.wholeStr.length()) {
                    this.spBuilder.insert(position, insertStr);
                }
            } else if(TextUtils.isEmpty(this.wholeStr) && !TextUtils.isEmpty(this.highlightStr) && position >= 0 && position <= this.highlightStr.length()) {
                this.spBuilder.insert(position, insertStr);
            }

            return this;
        }
    }
}
