package com.example.xc.zhoukaozuoyea;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import org.xutils.x;

import Url.MyUrl;

public class TwoActivity extends Activity {
private ListView liv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        if (Build.VERSION_CODES.KITKAT >= 19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        liv= (ListView) findViewById(R.id.tity_lv);
        x.view().inject(this);
        MyData myData = new MyData();
        myData.MyDataGet2(this,liv,MyUrl.path2);
    }
}
