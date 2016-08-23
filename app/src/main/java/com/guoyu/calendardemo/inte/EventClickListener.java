package com.guoyu.calendardemo.inte;

import android.graphics.RectF;

import com.guoyu.calendardemo.bean.DayViewEvent;

/**
 * Created by gyz on 2016/8/23.
 */
public interface EventClickListener {
    void onEventClick(DayViewEvent event, RectF eventRectf);
}
