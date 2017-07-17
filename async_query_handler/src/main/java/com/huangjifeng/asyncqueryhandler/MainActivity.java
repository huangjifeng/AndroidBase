package com.huangjifeng.asyncqueryhandler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * AsyncQueryHandler：主要作用就是异步对DB数据库进行操作，加快其数据处理的速度
 */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MyAsyncQueryHandler queryHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        queryHandler = new MyAsyncQueryHandler(getContentResolver());


    }


}
