package com.example.xc.zhoukaozuoyea;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import org.xutils.x;
public class MainActivity extends AppCompatActivity {


    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION_CODES.KITKAT >= 19) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        //  x.view().inject(this)来完成视图注解框架的初始化。
        x.view().inject(this);
        cehuaData();


    }

    private void cehuaData() {

        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);

        //设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        WindowManager wm = getWindowManager();
        //获取整个屏幕的大小
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        float widthPixels = (float) displayMetrics.widthPixels;
        double v = (int) widthPixels * 0.8;
        menu.setBehindWidth((int)v);
        //设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
/**
 * SLIDING_WINDOW will include the Title/ActionBar in the content
 * section of the SlidingMenu, while SLIDING_CONTENT does not.
 */
//设置滑动的屏幕局限，该设置为全屏区域都可以滑动
//menu.attachToActivity(this, 1);
//使SlidingMenu附加在Activity上
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//为侧滑菜单设置布局
        menu.setMenu(getLeftMenu());
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
    }


    public View getLeftMenu() {
        //从主布局文件绑定的Activity调用另一个布局文件必须调用LayoutInflater
        LayoutInflater layoutInflater = getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.chehua, null);
        lv = (ListView) v.findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                    startActivity(intent);
                }else if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, SanActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, QuanActivity.class);
                    startActivity(intent);
                }
            }
        });
        MyData myData = new MyData();
        myData.MyDataGet(this, lv);
        return v;
    }

}
