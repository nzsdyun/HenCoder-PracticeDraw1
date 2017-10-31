package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {
    private static final int AXIS_Y_MIN = 0;
    private static final int AXIS_Y_MAX = 10;
    Path mAxisPath = new Path();
    private String[] mAxisX = new String[] {
            "Froyo", "GB", "ICS", "JB", "KitKat", "L", "M",
    };
    private float[] mData = new float[] {
            0.3f, 0.6f, 0.6f, 4.1f, 6.1f, 8f, 3.5f
    };
    private Paint mPaint = new Paint();

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int l = 100;
        int t = 20;
        int r = getWidth() - 60;
        int b = getHeight() - 100;
        int axisH = b - t;
        int axisW = r - l;
        // draw axis
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mAxisPath.moveTo(l, t);
        mAxisPath.rLineTo(0, axisH);
        mAxisPath.rLineTo(axisW, 0);
        canvas.drawPath(mAxisPath, mPaint);
        // draw y axis content
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(20);
        mPaint.setTextAlign(Paint.Align.RIGHT);
        int step = axisH / (AXIS_Y_MAX - AXIS_Y_MIN);
        for (int top = t, i = 0; top <= axisH; i++) {
            canvas.drawText((AXIS_Y_MAX - i) + "", l - 5, top = t + i * step, mPaint);
        }
        // draw x axis content
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(40);
        int stepW = axisW / (mAxisX.length);
        for (int i = 0; i < mAxisX.length; i++) {
            canvas.drawText(mAxisX[i], l + i * stepW  + stepW / 2, b - mPaint.getFontMetrics().top, mPaint);
        }
        // draw histogram
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        int dW = axisW / (mData.length);
        for (int j = 0; j < mData.length; j++) {
            float dl = l + j * dW + 10;
            float dt = t + (AXIS_Y_MAX - mData[j]) * step;
            float dr = dl + dW - 10;
            float db = b;
            canvas.drawRect(new RectF(dl, dt, dr, db), mPaint);
        }
    }
}
