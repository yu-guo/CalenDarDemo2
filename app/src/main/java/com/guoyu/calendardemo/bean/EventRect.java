package com.guoyu.calendardemo.bean;

import android.graphics.RectF;

/**
 * Created by gyz on 2016/8/23.
 */
public class EventRect {

    public DayViewEvent mEvent;
    public DayViewEvent originalEvent;
    public RectF mRectF;
    public float left;
    public float width;
    public float top;
    public float bottom;


    public EventRect(DayViewEvent event, DayViewEvent originalEvent, RectF rectF) {
        mEvent = event;
        this.originalEvent = originalEvent;
        mRectF = rectF;
    }

    @Override
    public String toString() {
        return "EventRect{" +
                "mEvent=" + mEvent +
                ", originalEvent=" + originalEvent +
                ", mRectF=" + mRectF +
                ", left=" + left +
                ", width=" + width +
                ", top=" + top +
                ", bottom=" + bottom +
                '}';
    }
}
