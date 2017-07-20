package com.huangjifeng.preferencefragment;

import android.os.Bundle;


public class MyPreferenceActivity extends android.preference.PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }


}
