package com.huangjifeng.preferencefragment;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

/**
 * Preference 控件简介：
 * Preference --- TextView --- 文本框
 * CheckPreference --- CheckBox --- 单选框
 * EditTextPreference --- EditText --- 输入文本框
 * ListPreference --- ListView --- 列表框
 * RingtonePreference --- 铃声
 * <p>
 * PreferenceCategory：类似于LinearLayou、RelativeLayout，用于组合一组Preference，使布局更具备层次感 。
 * PreferenceScreen：所有Preference元素的根节点
 * <p>
 * <p>
 * <p>
 * <p>
 * 显示Preference布局结构的方法为：
 * google 不推荐Activity继承PreferenceActivity，可以自定义Fragment继承自PreferenceFragment
 * addPreferencesFromResource(R.xml.setting);(我们自定义的Preference 布局)。
 * findPreference(KEY);  通过key找到Preference
 * OnPreferenceChangeListener：当状态发生改变是触发
 * OnPreferenceClickListener：当被点击是触发
 * <p>
 * <p>
 * <p>
 * <p>
 * 各种Preference的方法和属性详解：
 * EditTextPreference:
 * getEditText()  返回的是我们在该控件中输入的文本框值
 * getText()     返回的是我们之前sharedPreferen文件保存的值
 * <p>
 * ListPreference:
 * android:dialogTitle：弹出控件对话框时显示的标题
 * android:entries：类型为array，控件欲显示的文本
 * android:entryValues：类型为array，与文本相对应的key-value键值对，value保存至sharedPreference文件
 * getEntries()： 返回的是控件显示文本的一个”key”数组，对应于属性android:entries
 * getEntryValues()：返回的一个”value”数组，对应于属性android: entryValues
 * getEntry(): 返回当前选择文本
 * getValue() :返回当前选中文本选中的value 。
 * <p>
 * RingtonePreference:
 * android:ringtoneType：响铃的铃声类型，主要有：ringtone(音乐)、notification(通知)、alarm(闹铃)、all(所有可用声 音类型)。
 * android:showDefault ：默认铃声，可以使用系统(布尔值---true,false)的或者自定义的铃声
 * android:showSilent  ：指定铃声是否为静音。指定铃声包括系统默认铃声或者自定义的铃声
 * <p>
 * <p>
 * <p>
 * 3个基本方法的触发规则：
 * 1 先调用onPreferenceClick()方法，如果该方法返回true，则不再调用onPreferenceTreeClick方法 ；
 * 如果onPreferenceClick方法返回false，则继续调用onPreferenceTreeClick方法。
 * 2 onPreferenceChange的方法独立与其他两种方法的运行。也就是说，它总是会运行。
 * 补充：点击某个Preference控件后，会先回调onPreferenceChange()方法，即是否保存值，然后再回调
 * onPreferenceClick以及onPreferenceTreeClick()方法，因此在onPreferenceClick/onPreferenceTreeClick
 * 方法中我们得到的控件值就是最新的Preference控件值。
 */

public class MyPreferenceFragment extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) findPreference("checkbox_preference");
        checkBoxPreference.setOnPreferenceChangeListener(this);
        checkBoxPreference.setOnPreferenceClickListener(this);
    }

    /**
     * 比较重要的监听点击事件方法，当Preference控件被点击时，触发该方法
     * 返回 true  代表点击事件已成功捕捉，无须执行默认动作或者返回上层调用链。 例如，不跳转至默认Intent。
     * 返回 false 代表执行默认动作并且返回上层调用链。例如，跳转至默认Intent
     */
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    /**
     * 当Preference的元素值发送改变时，触发该事件。
     * 返回值：true  代表将新值写入sharedPreference文件中。false 则不将新值写入sharedPreference文件
     */
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        switch (preference.getKey()) {
            case "checkbox_preference":
                break;
        }
        return false;
    }

    /**
     * 当点击控件时触发发生，可以做相应操作。
     */
    @Override
    public boolean onPreferenceClick(Preference preference) {
        return false;
    }


}
