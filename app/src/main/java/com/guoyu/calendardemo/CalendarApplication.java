package com.guoyu.calendardemo;

import android.app.Application;

import com.guoyu.calendardemo.constant.Constant;
import com.orhanobut.logger.Logger;

/**
 * Created by gyz on 2016/8/19.
 */
public class CalendarApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initLogger();
    }

    private void initLogger() {
        Logger.init(Constant.LoggerInit);

    }
}
