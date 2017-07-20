package com.huangjifeng.preferencefragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * 目前google建议使用PreferenceFragment代替PreferenceActivity
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityhaha";
    private EditText input_edit;
    private static final int menu_setting = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_edit = (EditText) findViewById(R.id.input_text);

        /**
         * 以下为对PreferenceFragment保存指的调用
         * */
        SharedPreferences sps = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isahha = sps.getBoolean("parent_checkbox_preference", false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, menu_setting, 1, "设置").setIcon(android.R.drawable.ic_menu_preferences);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        Intent intent = new Intent(this, MyPreferenceActivity.class);
        startActivity(intent);
        return false;
    }

    /**
     * SharedPreferences的使用范围：
     * 1、调用Context对象的getSharedPreferences()方法获得的SharedPreferences对象可以被同一应用程序下的其他组件共享.
     * 2、调用Activity对象的getPreferences()方法获得的SharedPreferences对象只能在该Activity中使用.
     * <p>
     * SharedPreferences的四种操作模式:
     * 1、Context.MODE_PRIVATE：为默认操作模式,代表该文件是私有数据,只能被应用本身访问,在该模式下,写入的内容会覆盖原文件的内容
     * 2、Context.MODE_APPEND：模式会检查文件是否存在,存在就往文件追加内容,否则就创建新文件.
     * 3、Context.MODE_WORLD_READABLE：表示当前文件可以被其他应用读取.
     * 4、Context.MODE_WORLD_WRITEABLE：表示当前文件可以被其他应用写入.
     */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save:
                String text = input_edit.getText().toString();
                if (!text.isEmpty()) {
                    SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", text);
                    editor.commit();
                }
                break;
            case R.id.get:
                SharedPreferences sharedPreferences01 = getSharedPreferences("user", MODE_PRIVATE);
                String name = sharedPreferences01.getString("name", "小明");
                Log.i(TAG, "onClick: name = " + name);
                break;
        }
    }
}
