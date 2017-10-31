package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private Paint mCirclePaint;
    public Practice2DrawCircleView(Context context) {
        super(context);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.BLACK);
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setDither(true);
        mCirclePaint.setStrokeWidth(2);
        mCirclePaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        // draw 1
        int radius = getWidth() / 7;
        int cx1 = getWidth() / 6 + radius;
        int cy1 = 5 + radius;
        canvas.drawCircle(cx1, cy1, radius, mCirclePaint);
        // draw 2
        mCirclePaint.setStyle(Paint.Style.STROKE);
        int cx2 = cx1 + 2 * radius + 20;
        int cy2 = cy1;
        canvas.drawCircle(cx2, cy2, radius, mCirclePaint);
        // draw 3
        mCirclePaint.reset();
        mCirclePaint.setColor(Color.BLUE);
        int cx3 = cx1;
        int cy3 = cy1 + 2 * radius + 30;
        canvas.drawCircle(cx3, cy3, radius, mCirclePaint);
        // draw 4
        mCirclePaint.reset();
        mCirclePaint.setStrokeWidth(20);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        int cx4 = cx2;
        int cy4 = cy3;
        canvas.drawCircle(cx4, cy4, radius, mCirclePaint);

    }
}
