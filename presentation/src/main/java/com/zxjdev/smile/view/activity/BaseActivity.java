package com.zxjdev.smile.view.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * 所有Activity的基类
 * Created by Andrew on 7/4/16.
 */
public abstract class BaseActivity extends Activity {

    protected Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
