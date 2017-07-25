package com.huangjifeng.toolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * ToolBar必须是在继承自AppCompatActivity的Actiivty类中使用
 * 一般将toolBar设置在基类当中，这样可以增加类的复用性
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_add_white_24dp);     //设置 toolbar 的logo
        toolbar.setTitle("Tool Bar Demo");                 //设置 toolbar 的title
        toolbar.setSubtitle("子标题");
        //toolbar.hideOverflowMenu();          //隐藏OverflowMenu，但是一般点击menu外面都能隐藏掉
        setSupportActionBar(toolbar);          //获取到Toolbar将其设置为操作栏

        //setNavigationIcon需要放在 setSupportActionBar之后才会生效
        //toolbar.setNavigationIcon(R.drawable.ic_pause_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /**
         这个方法和上面的方法是设置同一个东西，但是上面这个可以自定义图片，而且最好是使用上面的

         toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        Toast.makeText(MainActivity.this, "返回上一页了", Toast.LENGTH_SHORT).show();
        }
        });
         */


        //toolbar.setOnMenuItemClickListener(onMenuItemClickListener);  //menu中item的监听
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.edit:
                msg += "click edit";
                break;
            case R.id.share:
                msg += "click share";
                break;
            case R.id.setting:
                msg += "click setting";
                break;
            case android.R.id.home:
                Toast.makeText(MainActivity.this, "返回上一页了", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        if (!msg.equals("")) {
            Toast.makeText(MainActivity.this, "按的键是" + msg, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_action_view:
                startActivity(new Intent(this, ActionViewActivity.class));
                break;
        }
    }

    /**
     * 这个menu的监听其实和onOptionsItemSelected(MenuItem item)方法的用处向冲突了
     * private Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
     *String msg = "";
     @Override public boolean onMenuItemClick(MenuItem item) {
     switch (item.getItemId()) {
     case R.id.edit:
     msg += "click edit";
     break;
     case R.id.share:
     msg += "click share";
     break;
     case R.id.setting:
     msg += "click setting";
     break;
     }
     if (!msg.equals("")) {
     Toast.makeText(MainActivity.this, "按的键是" + msg, Toast.LENGTH_SHORT).show();
     }
     return true;
     }
     };*/


}
