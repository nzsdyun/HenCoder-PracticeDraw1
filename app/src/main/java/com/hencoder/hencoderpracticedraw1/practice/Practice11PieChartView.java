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

public class Practice11PieChartView extends View {
    private Paint mPaint = new Paint();
    private PieChart[] mData = new PieChart[] {
            new PieChart("Lollipop", 0.3f, Color.RED),
            new PieChart("Marshmallow", 0.1f, Color.YELLOW),
            new PieChart("Froyo", 0.05f, Color.rgb(139, 0, 0)),
            new PieChart("Gingerbread", 0.12f, Color.rgb(0, 139, 139)),
            new PieChart("Ice Cream Sandwich", 0.08f, Color.rgb(40, 79, 79)),
            new PieChart("Jelly Bean", 0.1f, Color.GRAY),
            new PieChart("KitKat", 0.25f, Color.BLUE)
    };
    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        float startAngle = -185;
        int radius = (getHeight() * 3 / 4) / 2;
        float l = 200;
        float t = 50;
        float r = l + 2 * radius;
        float b = t + 2 * radius;
        float cx = l + radius;
        float cy = t + radius;
        for (int i = 0; i < mData.length; i++) {
            PieChart pieChart = mData[i];
            float sweepAngle = 360 * pieChart.getRatio();
            // draw arc
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setAntiAlias(true);
            mPaint.setColor(pieChart.getColor());
            if (i == 0) {
                canvas.drawArc(new RectF(l - 20, t - 20, r, b), startAngle, sweepAngle, true, mPaint);
            } else {
                canvas.drawArc(new RectF(l, t, r, b), startAngle, sweepAngle, true, mPaint);
            }
            // draw line and title
            mPaint.setColor(Color.WHITE);
            mPaint.setStrokeWidth(2);
            mPaint.setStyle(Paint.Style.STROKE);
            Path linePath = new Path();
            float middleArcAngle = startAngle + sweepAngle / 2;
            float lsx = (float) (cx + radius * Math.cos(Math.PI * middleArcAngle / 180));
            float lsy = (float) (cy + radius * Math.sin(Math.PI * middleArcAngle / 180));
            linePath.moveTo(lsx, lsy);
            int dx = 10;
            int dy = 10;
            int dd = 80;
            float startX = lsx + dx + dd;
            float centLine =  lsy + dy;
            float baseLineY = centLine;
            mPaint.setStyle(Paint.Style.STROKE);
            if ((middleArcAngle > 180 && middleArcAngle < 270)
                    || (middleArcAngle > -180 && middleArcAngle < -90)) {
                // left top
                linePath.rLineTo(-dx, -dy);
                linePath.rLineTo(-dd, 0);
                startX = lsx - (dx + dd);
                centLine = lsy - dy;
                Paint.FontMetrics textFontMetrics = mPaint.getFontMetrics();
                baseLineY = centLine + (textFontMetrics.bottom - textFontMetrics.top) / 2 - textFontMetrics.bottom;
                mPaint.setTextAlign(Paint.Align.RIGHT);
            } else if (middleArcAngle == -90 || middleArcAngle == 270) {
                // top
                linePath.rLineTo(0, -dy);
                startX = lsx;
                centLine = lsy - dy;
                baseLineY = centLine - 10;
                mPaint.setTextAlign(Paint.Align.CENTER);
            } else if ((middleArcAngle > 270 && middleArcAngle < 360)
                    || (middleArcAngle > -90 && middleArcAngle < 0)) {
                // right top
                linePath.rLineTo(dx, -dy);
                linePath.rLineTo(dd, 0);
                startX = lsx + (dx + dd);
                centLine = lsy - dy;
                Paint.FontMetrics textFontMetrics = mPaint.getFontMetrics();
                baseLineY = centLine + (textFontMetrics.bottom - textFontMetrics.top) / 2 - textFontMetrics.bottom;
                mPaint.setTextAlign(Paint.Align.LEFT);
            } else if (middleArcAngle == 360 || middleArcAngle == 0) {
                //right
                linePath.rLineTo(dx, 0);
                startX = lsx + dx;
                centLine = lsy;
                Paint.FontMetrics textFontMetrics = mPaint.getFontMetrics();
                baseLineY = centLine + (textFontMetrics.bottom - textFontMetrics.top) / 2 - textFontMetrics.bottom;
                mPaint.setTextAlign(Paint.Align.LEFT);
            } else if (middleArcAngle > 0 && middleArcAngle < 90) {
                // right bottom
                linePath.rLineTo(dx, dy);
                linePath.rLineTo(dd, 0);
                startX = lsx + dx + dd;
                centLine = lsy + dy;
                Paint.FontMetrics textFontMetrics = mPaint.getFontMetrics();
                baseLineY = centLine + (textFontMetrics.bottom - textFontMetrics.top) / 2 - textFontMetrics.bottom;
                mPaint.setTextAlign(Paint.Align.LEFT);
            } else if (middleArcAngle == -270 || middleArcAngle == 90) {
                // bottom
                linePath.rLineTo(0, dy);
                startX = lsx;
                centLine = lsy + dy;
                baseLineY = centLine + 10;
                mPaint.setTextAlign(Paint.Align.CENTER);
            } else if ((middleArcAngle > -270 && middleArcAngle < -180)
                    || (middleArcAngle > 90 && middleArcAngle < 180)) {
                // left bottom
                linePath.rLineTo(-dx, dy);
                linePath.rLineTo(-dd, 0);
                startX = lsx - (dx + dd);
                centLine = lsy + dy;
                Paint.FontMetrics textFontMetrics = mPaint.getFontMetrics();
                baseLineY = centLine + (textFontMetrics.bottom - textFontMetrics.top) / 2 - textFontMetrics.bottom;
                mPaint.setTextAlign(Paint.Align.RIGHT);
            } else if (middleArcAngle == -180 || middleArcAngle == 180) {
                // left
                linePath.rLineTo(-dx, 0);
                startX = lsx - dx;
                centLine = lsy;
                Paint.FontMetrics textFontMetrics = mPaint.getFontMetrics();
                baseLineY = centLine + (textFontMetrics.bottom - textFontMetrics.top) / 2 - textFontMetrics.bottom;
                mPaint.setTextAlign(Paint.Align.RIGHT);
            }
            canvas.drawPath(linePath, mPaint);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setTextSize(30);
            canvas.drawText(pieChart.getTitle(), startX, baseLineY, mPaint);
            startAngle += sweepAngle;
        }

    }

    static class PieChart {
        private String title;
        private float ratio;
        private int color;
        public PieChart(String title, float ratio, int color) {
            this.title = title;
            this.ratio = ratio;
            this.color = color;
        }

        public String getTitle() {
            return title;
        }

        public float getRatio() {
            return ratio;
        }

        public int getColor() {
            return color;
        }
    }
}
