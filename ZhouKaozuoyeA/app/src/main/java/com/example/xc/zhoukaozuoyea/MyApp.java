package com.example.xc.zhoukaozuoyea;

import android.app.Application;
import org.xutils.x;

/**
 * data:2017/4/16
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

    }
}
