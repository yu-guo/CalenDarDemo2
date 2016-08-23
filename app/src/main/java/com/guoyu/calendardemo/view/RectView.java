package com.guoyu.calendardemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gyz on 2016/8/22.
 */
public class RectView extends View {

    public RectView(Context context) {
        this(context,null);
    }

    public RectView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.argb(255, 255, 255, 255));
        paint.setStyle(Paint.Style.STROKE);

        Rect rect1 = new Rect(10, 200, 300, 400);
        canvas.drawRect(rect1, paint);

        RectF rectF1 = new RectF(40.5f, 200.5f, 600.5f, 400.5f);
        canvas.drawRect(rectF1, paint);


        canvas.drawRect(10, 500, 300, 800, paint);
    }
}
