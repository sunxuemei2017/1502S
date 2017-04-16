package com.example.xc.zhoukaozuoyea;

import android.content.Context;
import android.widget.ListView;
import com.google.gson.Gson;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.util.List;
import Baseadapter.MyBasedata;
import Baseadapter.MyTitlebase;
import Bean.MyBean1;
import Bean.MytitleBean;
import Url.MyUrl;


/**
 * data:2017/4/16
 */

public class MyData {


    // get请求 的方法
    public static void MyDataGet(final Context context, final ListView lv){
        RequestParams params = new RequestParams(MyUrl.path1);
        params.addQueryStringParameter("username","abc");
        params.addQueryStringParameter("password","123");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析result
                Gson gson = new Gson();
                MytitleBean mytitleBean = gson.fromJson(result, MytitleBean.class);
                List<MytitleBean.DataBean> data = mytitleBean.getData();
                MyTitlebase myTitlebase = new MyTitlebase(context, data);
                lv.setAdapter(myTitlebase);
            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });
    }


    public static void MyDataGet2(final Context context, final ListView lv, String path) {
        RequestParams params = new RequestParams(path);

        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析result
                Gson gson = new Gson();
                MyBean1 myBean1 = gson.fromJson(result, MyBean1.class);
                List<MyBean1.DataBean> data11 = myBean1.getData();
                MyBasedata myBasedata = new MyBasedata(data11, context);
                lv.setAdapter(myBasedata);
            }

            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }

            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
            }
        });
    }

}
