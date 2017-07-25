package com.huangjifeng.actionbar;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         ActionBar actionBar = getSupportActionBar();
         actionBar.hide();      //ActionBar的隐藏
         actionBar.show();      //ActionBar的显示
         actionBar.isShowing(); //判断ActionBar是否显示了
         */
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.ic_add_white_24dp);
    }
}
