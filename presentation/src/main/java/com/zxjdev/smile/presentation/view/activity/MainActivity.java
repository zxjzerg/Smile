package com.zxjdev.smile.presentation.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.view.activity.base.BaseActivity;
import com.zxjdev.smile.presentation.view.activity.moment.MomentsFragment;
import com.zxjdev.smile.presentation.view.activity.settings.SettingsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.dlyt_container) DrawerLayout mDlytContainer;
    @BindView(R.id.view_toolbar) Toolbar mViewToolbar;
    @BindView(R.id.view_navigation) NavigationView mViewNavigation;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUi();

        if (savedInstanceState == null) {
            replaceFragment(R.id.flyt_content, new MomentsFragment(), MomentsFragment.TAG);
            mViewNavigation.setCheckedItem(R.id.navi_item_moments);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private void initUi() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDlytContainer, mViewToolbar, R.string.open,
            R.string.close);

        initNavigationView();
    }

    private void initNavigationView() {
        // 添加侧边菜单的点击事件
        mViewNavigation.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navi_item_moments:
                    replaceFragment(R.id.flyt_content, new MomentsFragment());
                    break;
                case R.id.navi_item_settings:
                    replaceFragment(R.id.flyt_content, new SettingsFragment());
                    break;
            }
            mDlytContainer.closeDrawers();
            return true;
        });

        if (mViewNavigation.getHeaderCount() > 0) {
            View view = mViewNavigation.getHeaderView(0);
        }
    }

    private void setNavigationHeader() {

    }
}