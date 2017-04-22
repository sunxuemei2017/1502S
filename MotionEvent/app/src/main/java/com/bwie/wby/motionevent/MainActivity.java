package com.bwie.wby.motionevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity ";
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.MotionEvent);
        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN://按下

                        Log.e(TAG, "---onTouchEvent action:ACTION_DOWN" + "----------按下");
                        Toast.makeText(MainActivity.this, "---onTouchEvent action:ACTION_DOWN\" + \"----------按下", Toast.LENGTH_SHORT).show();

                        break;
                    case MotionEvent.ACTION_MOVE://移动

                        Log.e(TAG, "---onTouchEvent action:ACTION_MOVE" + "----------移动");
                        Toast.makeText(MainActivity.this, "---onTouchEvent action:ACTION_MOVE\" + \"----------移动", Toast.LENGTH_SHORT).show();

                        break;
                    case MotionEvent.ACTION_UP://抬起

                        Log.e(TAG, "---onTouchEvent action:ACTION_UP" + "----------抬起");
                        Toast.makeText(MainActivity.this, "---onTouchEvent action:ACTION_UP\" + \"----------抬起", Toast.LENGTH_SHORT).show();

                        break;
                    case MotionEvent.ACTION_CANCEL://取消

                        Log.e(TAG, "---onTouchEvent action:ACTION_CANCEL" + "----------取消");
                        Toast.makeText(MainActivity.this, "---onTouchEvent action:ACTION_CANCEL\" + \"----------取消", Toast.LENGTH_SHORT).show();

                        break;
                    case MotionEvent.ACTION_OUTSIDE://超出边界

                        Log.e(TAG, "---onTouchEvent action:ACTION_OUTSIDE" + "----------超出边界");
                        Toast.makeText(MainActivity.this, "---onTouchEvent action:ACTION_OUTSIDE\" + \"----------超出边界", Toast.LENGTH_SHORT).show();

                       break;
                    case MotionEvent.ACTION_POINTER_DOWN://多点触摸

                        Log.e(TAG, "---onTouchEvent action:ACTION_POINTER_DOWN" + "----------多点触摸");
                        Toast.makeText(MainActivity.this, "---onTouchEvent action:ACTION_POINTER_DOWN\" + \"----------多点触摸", Toast.LENGTH_SHORT).show();

                        break;
                    case MotionEvent.ACTION_POINTER_UP://多点离开

                        Log.e(TAG, "---onTouchEvent action:ACTION_POINTER_UP" + "----------多点离开");
                        Toast.makeText(MainActivity.this, "---onTouchEvent action:ACTION_POINTER_UP\" + \"----------多点离开", Toast.LENGTH_SHORT).show();

                        break;
                }
                return false;
            }
        });
    }


}