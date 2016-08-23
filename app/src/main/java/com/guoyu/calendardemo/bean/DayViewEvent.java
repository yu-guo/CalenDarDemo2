package com.guoyu.calendardemo.bean;

import java.util.Calendar;

/**
 * Created by gyz on 2016/8/23.
 */
public class DayViewEvent {
    private long mId;
    private Calendar mStartTime;
    private Calendar mEndTime;
    private String mName;
    private String location;
    private int mColor;

    public DayViewEvent() {
    }

    /**
     *
     * @param id
     * @param name
     * @param startYear
     * @param startMonth
     * @param startDay
     * @param startHour
     * @param startMinute
     * @param endYear
     * @param endMonth
     * @param endDay
     * @param endHour
     * @param endMinute
     */
    public DayViewEvent(long id, String name, int startYear, int startMonth, int startDay, int startHour, int startMinute,
                        int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        this.mId = id;

        this.mStartTime = Calendar.getInstance();
        this.mStartTime.set(Calendar.YEAR, startYear);
        this.mStartTime.set(Calendar.MONTH, startMonth-1);
        this.mStartTime.set(Calendar.DAY_OF_MONTH, startDay);
        this.mStartTime.set(Calendar.HOUR_OF_DAY, startHour);
        this.mStartTime.set(Calendar.MINUTE, startMinute);

        this.mEndTime = Calendar.getInstance();
        this.mEndTime.set(Calendar.YEAR, endYear);
        this.mEndTime.set(Calendar.MONTH, endMonth-1);
        this.mEndTime.set(Calendar.DAY_OF_MONTH, endDay);
        this.mEndTime.set(Calendar.HOUR_OF_DAY, endHour);
        this.mEndTime.set(Calendar.MINUTE, endMinute);

        this.mName = name;
    }

    public DayViewEvent(long id, Calendar startTime, Calendar endTime, String name, String location, int color) {
        mId = id;
        mStartTime = startTime;
        mEndTime = endTime;
        mName = name;
        this.location = location;
        mColor = color;
    }

    @Override
    public String toString() {
        return "DayViewEvent{" +
                "mId=" + mId +
                ", mStartTime=" + mStartTime +
                ", mEndTime=" + mEndTime +
                ", mName='" + mName + '\'' +
                ", location='" + location + '\'' +
                ", mColor=" + mColor +
                '}';
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public Calendar getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Calendar startTime) {
        mStartTime = startTime;
    }

    public Calendar getEndTime() {
        return mEndTime;
    }

    public void setEndTime(Calendar endTime) {
        mEndTime = endTime;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }
}
