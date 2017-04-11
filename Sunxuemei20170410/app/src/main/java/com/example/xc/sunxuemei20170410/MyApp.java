package com.example.xc.sunxuemei20170410;

import android.app.Application;

import org.xutils.x;

/**
 * 作者：老孙
 * 时间：4.11
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能
    }
}