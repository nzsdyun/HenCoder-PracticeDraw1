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

public class Practice9DrawPathView extends View {
    private Paint mPaint = new Paint();

    {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
    }

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Path path = new Path();
        int ll = getWidth() / 3;
        int lt = getHeight() / 3;
        int lr = ll + 200;
        int lb = lt + 200;
        RectF lRectF = new RectF(ll, lt, lr, lb);
        path.addArc(lRectF, -225, 225);
        int rl = lr;
        int rt = lt;
        int rr = rl + 200;
        int rb = rt + 200;
        RectF rRectF = new RectF(rl, rt, rr, rb);
        path.arcTo(rRectF, -180, 225);
        path.lineTo(lr, lt + 350);
        canvas.drawPath(path, mPaint);
    }
}
