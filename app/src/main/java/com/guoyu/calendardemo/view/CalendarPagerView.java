package com.guoyu.calendardemo.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.guoyu.calendardemo.bean.EventRect;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by gyz on 2016/8/24.
 */
public class CalendarPagerView extends ViewGroup {

    private TableTestView mTableTestView;

    private Context mContext;

    public CalendarPagerView(Context context) {
        this(context,null);
    }

    public CalendarPagerView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CalendarPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        mTableTestView = new TableTestView(context);
        this.addView(mTableTestView);

//        RectF rectf = new RectF(155.0f, 415.0f, 285.0f, 545.0f);
//        ChooseView choose = new ChooseView(context, rectf, Color.BLACK);
//        this.addView(choose);

//        Button button = new Button(context);
//        button.setText("点击");
//        this.addView(button);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        final int specWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int specWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int specHeightSize = MeasureSpec.getSize(heightMeasureSpec);
        final int specHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        Logger.i("onMeasure() -> specWidthSize:" + specWidthSize + ",specHeightSize:" + specHeightSize);
        final int measureTileWidth = specWidthSize;
        final int measureTileHeight = specHeightSize;

        setMeasuredDimension(measureTileWidth, measureTileHeight);

        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            int childWidthMeasureSpec = 0;
            int childHeightMeasureSpec = 0;
//            if (i == 0) {
                childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                        measureTileWidth,
                        MeasureSpec.EXACTLY
                );

                childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                        measureTileHeight,
                        MeasureSpec.EXACTLY
                );
//            }else {
//                childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
//                        mTableTestView.getWidth(),
//                        MeasureSpec.EXACTLY
//                );
//
//                childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
//                        mTableTestView.getHeight(),
//                        MeasureSpec.EXACTLY
//                );
//            }

            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        }

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        final int count = getChildCount();
        Logger.i("子布局的个数：" + count);


        final int parentLeft = 0;

        int childTop = 0;
        int childLeft = parentLeft;

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
//            if (i == 0) {

                final int width = child.getMeasuredWidth();
                final int height = child.getMeasuredHeight();

                child.layout(childLeft, childTop, childLeft + width, childTop + height);
//            } else {
//                List<EventRect> eveRects = mTableTestView.getCurrentEventRects();
//                if (eveRects != null) {
//                    EventRect eventRect = eveRects.get(22);
//                    if (eventRect != null) {
//                        child.layout((int) eventRect.mRectF.left, (int) eventRect.mRectF.top, (int) eventRect.mRectF.right, (int) eventRect.mRectF.bottom);
//                    }
//                }
//
//            }

        }


    }

    public void mergeView(Context context,int mergeNum) {
        List<EventRect> eveRects = mTableTestView.getCurrentEventRects();
        if (eveRects != null) {
            EventRect eventRect = eveRects.get(22);
            if (eventRect != null) {
                ChooseView chooseVIew = new ChooseView(context,eventRect.mRectF, Color.rgb(40, 209, 170));
                this.addView(chooseVIew);
            }
        }
    }
}
