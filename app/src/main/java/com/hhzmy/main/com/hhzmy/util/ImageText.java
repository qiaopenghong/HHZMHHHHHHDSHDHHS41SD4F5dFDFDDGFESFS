package com.hhzmy.main.com.hhzmy.util;

import android.app.Application;

/**
 * Created by qiao on 2016/11/14.
 */
public class ImageText extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderUtils.initConfiguration(getApplicationContext());
    }
}
