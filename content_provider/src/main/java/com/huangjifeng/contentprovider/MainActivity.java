package com.huangjifeng.contentprovider;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * http://blog.csdn.net/ruingman/article/details/51324837
 * 在Android官方指出的Android的数据存储方式总共有五种，分别是：Shared Preferences、网络存储、文件存储、
 * 外储存储、SQLite。
 * <p>
 * （1）ContentProvider为存储和获取数据提供了统一的接口
 */

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler() {
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Looper looper = Looper.myLooper();
                MessageQueue messageQueue = Looper.myQueue();
                Message message = Message.obtain();
                Message message1 = handler.obtainMessage();
                message.recycle();



            }
        }).start();
    }
}
