package com.example.xc.zhoukaozuoyea;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import org.xutils.x;

import Url.MyUrl;

public class QuanActivity extends Activity {
private ListView tity_quanbu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan);
        if (Build.VERSION_CODES.KITKAT >= 19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        tity_quanbu= (ListView) findViewById(R.id.tity_quanbu);
        x.view().inject(this);
        MyData myData = new MyData();
        myData.MyDataGet2(this,tity_quanbu,MyUrl.getPath4);
    }
}
