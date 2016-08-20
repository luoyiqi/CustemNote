package com.yus.noteview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

/**
 * Created by ${余胜} on 2016/8/20.
 */
public class NoteEditText extends EditText {
    //横线的线宽
    private int lineWidth = 1;
    //横线的颜色
    private int lineColor = Color.BLACK;
    //行间距
    private int spacing_line = 10;
    //内边距
    private int padding = 10;
    //画笔
    private Paint mPaint;
    public NoteEditText(Context context) {
        super(context);
        init(context);
    }

    public NoteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NoteEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setFocusableInTouchMode(true);
        setGravity(Gravity.TOP);
        setLineSpacing(spacing_line, 1);
        setPadding(25, 10, padding, 10);
        mPaint = new Paint();
        mPaint.setColor(lineColor);
        mPaint.setStrokeWidth(lineWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewHeight = getHeight();
        //获取每行文本的高度
        int lineHeight = getLineHeight();
        //计算每页一共有多少行
        int pageCount = viewHeight / lineHeight;
        //循环绘制横线
        for (int i = 0; i < pageCount; i++) {
            canvas.drawLine(padding, (i + 1) * lineHeight, getWidth() - padding, (i + 1) * lineHeight, mPaint);
        }
        //获取当前文本的总行数
        int lineCount = getLineCount();
        //文本的行数减去每页的行数，剩余的值就是我还要继续绘制的行数
        int extraCount = lineCount - pageCount;
    }
}
