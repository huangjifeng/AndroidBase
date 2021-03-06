package com.huangjifeng.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.huangjifeng.fragment.life.LifeActivity;
import com.huangjifeng.fragment.simpleuse.UseActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_01:
                startActivity(new Intent(MainActivity.this, LifeActivity.class));
                break;
            case R.id.button_02:
                startActivity(new Intent(MainActivity.this, UseActivity.class));
                break;
            case R.id.button_03:
                break;
        }
    }
}
