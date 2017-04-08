package com.example.onezhoukao;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ListView lv;
    private MyBeaseAdapter adapter;
    public static final String url="http://result.eolinker.com/KLn5hSP9f6fed196f92ec0148255a48aebb2c6cc5f97f0e?uri=user";
    private List<Bean.ListBean> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//  SlidingMenu菜單滑動

        // configure the SlidingMenu
        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        menu.setShadowWidthRes(50);
//        menu.setShadowDrawable(50);
        // 设置滑动菜单视图的宽度
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        int height = metric.heightPixels;
        menu.setBehindOffset(width/3);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.two_main);




        lv= (ListView) findViewById(R.id.listview);
        //创建异步线程
        MyAsyncTask my = new MyAsyncTask();
        //开启异步线程
        my.execute(url);
        //通过接口回调获取网络请求的数据
        my.huidiao(new MyAsyncTask.getjson() {
            @Override
            public void getjsonstr(String str) {
                Gson gson = new Gson();//创建一个Gson
                //将获取的json串转换成javaBean
                Bean jsonBean = gson.fromJson(str, Bean.class);
                list = jsonBean.getList();//返回集合
                adapter = new MyBeaseAdapter(MainActivity.this,list);
                lv.setAdapter(adapter);//添加适配器
            }
        });//设置条目点击吐丝站点的id
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"该站点的id"+list.get(i).getId(),Toast.LENGTH_LONG).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
