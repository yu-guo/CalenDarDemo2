package com.guoyu.calendardemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.guoyu.calendardemo.inte.EventClickListener;
import com.orhanobut.logger.Logger;

/**
 * Created by gyz on 2016/8/24.
 */
public class ChooseView extends View {
    /**
     * 选中位置的坐标
     */
    private RectF mRectF;

    private Paint choosePain;

    private int mColorInt;

    private GestureDetectorCompat mGestureDetector;

    private EventClickListener mEventClickListener;

    public void setEventClickListener(EventClickListener eventClickListener) {
        mEventClickListener = eventClickListener;
    }

    private GestureDetector.SimpleOnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            Logger.i(e.getX() + "," + e.getY());
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (mEventClickListener != null && e.getX() > mRectF.left && e.getX() < mRectF.right && e.getY() > mRectF.top && e.getY() < mRectF.bottom) {
                mEventClickListener.onEventClick(null, mRectF);
            }
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }
    };

    public void setRectFAndColor(RectF rectF,int colorInt) {
        mRectF = rectF;
        this.mColorInt = colorInt;
    }

    public ChooseView(Context context,RectF rectF,int colorInt) {
        super(context);
        this.mColorInt = colorInt;
        this.mRectF = rectF;
        mGestureDetector = new GestureDetectorCompat(context, mGestureListener);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        choosePain = new Paint();
        choosePain.setStyle(Paint.Style.FILL);
        choosePain.setColor(Color.BLACK);
        Logger.i("(" + mRectF.left + "," + mRectF.top + "," + mRectF.right + "," + mRectF.bottom);
        float left = mRectF.left;
        float top = mRectF.top;
        float right = mRectF.right + 2 * TableTestView.gridWidth;
        float bottom = mRectF.bottom;

        canvas.drawRect(left, top, right, bottom, choosePain);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean val = mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
