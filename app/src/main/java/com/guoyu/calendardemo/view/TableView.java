package com.guoyu.calendardemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by gyz on 2016/8/22.
 */
public class TableView extends View{

    /**
     * 默认列数
     */
    private static final int DEFAULT_COLUMNS_NUM = 7;
    /**
     * 列的默认高度
     */
    private static final int DEFAULT_COLUMNS_HEIGHT = 50;


    //当前控件的宽高
    private int currentViewWidth;
    private int currentViewHeight;
    /**
     * 列数
     */
    private int columnsNum = DEFAULT_COLUMNS_NUM;
    /**
     * 行数
     */
    private int rowsNum;
    /**
     * 每个格子的高度
     */
    private int columnHeight = DEFAULT_COLUMNS_HEIGHT;
    /**
     * 每个格子的宽度
     */
    private int rowWidth;


    /**
     * 画表格的画笔
     */
    private Paint tablePaint;

    public TableView(Context context) {
        this(context,null);
    }

    public TableView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TableView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        currentViewWidth = getWidth();
        currentViewHeight = getHeight();
        Logger.i("当前控件的宽高-> width:" + currentViewWidth + ",height：" + currentViewHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        currentViewWidth = getWidth();
        currentViewHeight = getHeight();
        Logger.i("onDraw 当前控件的宽高-> width:" + currentViewWidth + ",height：" + currentViewHeight);

    }

    private void drawTable(Canvas canvas) {
        //计算每格的宽度

    }
}
