package com.guoyu.calendardemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.guoyu.calendardemo.bean.DayViewEvent;
import com.guoyu.calendardemo.bean.EventRect;
import com.guoyu.calendardemo.inte.EmptyViewClickListener;
import com.guoyu.calendardemo.inte.EventClickListener;
import com.guoyu.calendardemo.inte.EventLongPressListener;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyz on 2016/8/23.
 */
public class TableTestView extends View{
    /**
     * 行数、列数
     */
    private int row,col;

    // 表格定位的左上角X和右上角Y
    private final static int STARTX = 25;
    private final static int STARTY = 25;

    //表格的宽度，高度
    private static float gridWidth;
    private static float gridHeight;

    private List<EventRect> mEventRects;
    private List<EventRect> mCurrentEventRects;


    private GestureDetectorCompat mGestureDetector;

    private EmptyViewClickListener mEmptyViewClickListener;
    private EventClickListener mEventClickListener;
    private EventLongPressListener mEventLongPressListener;

    private Canvas mCanvas;

    public void setEmptyViewClickListener(EmptyViewClickListener emptyViewClickListener) {
        mEmptyViewClickListener = emptyViewClickListener;
    }

    public void setEventClickListener(EventClickListener eventClickListener) {
        mEventClickListener = eventClickListener;
    }

    public void setEventLongPressListener(EventLongPressListener eventLongPressListener) {
        mEventLongPressListener = eventLongPressListener;
    }

    private final GestureDetector.SimpleOnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            Logger.i("当前点中的位置的坐标：(" + e.getX() + "," + e.getY() + ")");
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            //短时间单机一次
            EventRect clickEventRect = getCurrentClickPosition(e.getX(), e.getY());

            if (clickEventRect != null) {
                Logger.i("当前选中的：" + clickEventRect.mEvent.getName());
                if (mEmptyViewClickListener != null && clickEventRect.originalEvent == null) {
                    mEmptyViewClickListener.onEmptyViewClicked(clickEventRect.mEvent,clickEventRect.mRectF);
                }
            }

            return super.onSingleTapConfirmed(e);
        }
    };

    private EventRect getCurrentClickPosition(float x, float y) {
        for (EventRect eventRect : mCurrentEventRects) {
            if (x > eventRect.mRectF.left && x < eventRect.mRectF.right && y > eventRect.mRectF.top && y < eventRect.mRectF.bottom) {
                return eventRect;
            }
        }
        return null;
    }

    public TableTestView(Context context) {
        this(context, null);
    }

    public TableTestView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TableTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mGestureDetector = new GestureDetectorCompat(context, mGestureListener);
        row = 6;
        col = 7;

//        this.setFocusable(true);
//        this.setFocusableInTouchMode(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean val = mGestureDetector.onTouchEvent(event);
        return val;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //25 + 25 = 50
        gridWidth = (w - 50) / (this.col * 1.0f);
        if (this.row > this.col) {
            //行数大于列数，
            gridHeight = (h - 100) / (this.row * 1.0f);
        }else {
            //行数，小于或者等于
            gridHeight = gridWidth;
        }
//        Logger.i(STARTX + "," + STARTY);
//        Logger.i("gridWidth:" + gridWidth + ",gridHeight:" + gridHeight);

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mCanvas = canvas;

        if (mEventRects == null) {
            mEventRects = new ArrayList<>();
        }

        Paint paintRect = new Paint();
        paintRect.setColor(Color.rgb(40, 209, 170));
        paintRect.setStrokeWidth(2);
        paintRect.setStyle(Paint.Style.STROKE);
        canvas.drawRect(STARTX, STARTY, STARTX + gridWidth * this.col, STARTY + gridHeight * this.row, paintRect);

        //画表格的行和列 ,先画行，在画列
        paintRect.setStrokeWidth(1);
        for (int i = 0; i < this.row -1; i++) {
            canvas.drawLine(STARTX, STARTY + (i + 1) * gridHeight, STARTX + this.col * gridWidth, STARTY + (i + 1) * gridHeight, paintRect);
        }

        for (int j = 0; j < this.col - 1; j++) {
            canvas.drawLine(STARTX + (j + 1) * gridWidth, STARTY, STARTX + (j + 1) * gridWidth, STARTY + this.row * gridHeight, paintRect);
        }

        Paint paintText = new Paint();
        paintText.setColor(Color.rgb(79, 129, 189));
        paintText.setStyle(Paint.Style.STROKE);
        paintText.setTextAlign(Paint.Align.CENTER);
        paintText.setTextSize(32);
        Paint.FontMetrics fontMetrics = paintText.getFontMetrics();
        float fontHeight = fontMetrics.bottom - fontMetrics.top;
        int text = 0;
        if (mCurrentEventRects == null) {
            mCurrentEventRects = new ArrayList<>();
        }else {
            mCurrentEventRects.clear();
        }
        EventRect eventRect = null;
        DayViewEvent dayViewEvent = null;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                float mLeft = j * gridWidth + STARTX;
                float mTop = i * gridHeight + STARTY;
                float mRight = mLeft + gridWidth;
                float mBotttom = mTop + gridHeight;
//                Logger.i("第" + i + "行第" + j + "列" + "的坐标（left,top,right,bottom）:" +mLeft+ "," +mTop + "," + mRight + "," + mBotttom);
                RectF rectF = new RectF(mLeft,mTop,mRight,mBotttom);
                dayViewEvent = new DayViewEvent();
                text++;
                dayViewEvent.setId(text);
                dayViewEvent.setName(text + "");
                eventRect = new EventRect(dayViewEvent, null, rectF);
                mCurrentEventRects.add(eventRect);
                float textBaseY = (int) (gridHeight + fontHeight) >> 1;
                canvas.drawText(text + "", (int) (mLeft + mRight) >> 1, textBaseY + mTop, paintText);
            }
        }
    }

    public void merge(RectF rectF, int mergeNum) {
        Paint mergePaint = new Paint();
        mergePaint.setStyle(Paint.Style.FILL);
        mergePaint.setColor(Color.rgb(40, 209, 170));
        float right = rectF.left + mergeNum * gridWidth;
        Logger.i(rectF.left + "," + rectF.top + "," + rectF.right + "," + rectF.bottom);
        mCanvas.drawRect(rectF.left, rectF.top, right, rectF.bottom, mergePaint);

//        invalidate();
    }
}
