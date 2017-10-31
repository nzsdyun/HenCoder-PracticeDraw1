package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    private Paint mArcPaint;

    public Practice8DrawArcView(Context context) {
        super(context);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mArcPaint = new Paint();
        mArcPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        int l = getWidth() / 3;
        int t = getHeight() / 3;
        int r = getWidth() * 2 / 3;
        int b = getHeight() * 2 / 3;
        RectF arcRectF = new RectF(l, t, r, b);
        canvas.drawArc(arcRectF, -200, 90, false, mArcPaint);
        mArcPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(arcRectF, -100, 95, true, mArcPaint);
        canvas.drawArc(arcRectF, 35, 110, false, mArcPaint);
    }
}
