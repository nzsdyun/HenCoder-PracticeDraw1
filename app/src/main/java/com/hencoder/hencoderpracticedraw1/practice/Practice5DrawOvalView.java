package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice5DrawOvalView extends View {
    private Paint mOvalPaint;

    public Practice5DrawOvalView(Context context) {
        super(context);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mOvalPaint = new Paint();
        mOvalPaint.setAntiAlias(true);
        mOvalPaint.setStyle(Paint.Style.FILL);
        mOvalPaint.setColor(Color.BLACK);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        int l = getWidth() / 3;
        int t = getHeight() / 3;
        int r = getWidth() * 2 / 3;
        int b = getHeight() * 2 / 3;
        RectF ovalRectF = new RectF(l, t, r, b);
        canvas.drawOval(ovalRectF, mOvalPaint);
    }
}
