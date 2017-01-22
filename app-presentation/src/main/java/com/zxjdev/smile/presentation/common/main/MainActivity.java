package com.zxjdev.smile.presentation.common.main;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.BaseActivity;
import com.zxjdev.smile.presentation.application.di.component.MainActivityComponent;
import com.zxjdev.smile.presentation.application.di.module.ActivityModule;
import com.zxjdev.smile.presentation.application.di.module.MainActivityModule;
import com.zxjdev.smile.presentation.moment.list.MomentsFragment;
import com.zxjdev.smile.presentation.user.settings.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.dlyt_container) DrawerLayout mDlytContainer;
    @BindView(R.id.view_toolbar) Toolbar mViewToolbar;
    @BindView(R.id.view_navigation) NavigationView mViewNavigation;
    private ActionBarDrawerToggle mDrawerToggle;

    private MainActivityComponent mMainActivityComponent;

    private List<String> mFragmentTags = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUi();
        mFragmentTags.add(MomentsFragment.TAG);
        mFragmentTags.add(SettingsFragment.TAG);

        if (savedInstanceState == null) {
            showFragment(R.id.flyt_content, new MomentsFragment(), MomentsFragment.TAG);
            mViewNavigation.setCheckedItem(R.id.navi_item_moments);
        }
    }

    @Override
    protected void initializeInjector() {
        mMainActivityComponent = getApplicationComponent().plus(new ActivityModule(this),
            new MainActivityModule());
        mMainActivityComponent.inject(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    protected void onDestroy() {
        mMainActivityComponent = null;
        super.onDestroy();
    }

    private void initUi() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDlytContainer, mViewToolbar, R.string.open,
            R.string.close);

        // disable the default implementation of ActionBarDrawerToggle adding a navigation icon to
        // the Toolbar, because we cannot change the icon style
        mDrawerToggle.setDrawerIndicatorEnabled(false);
        // set custom navigation icon in the ToolBar
        mViewToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        // handle click event for showing the drawer
        mViewToolbar.setNavigationOnClickListener(v -> mDlytContainer.openDrawer(Gravity.LEFT));

        initNavigationView();
    }

    private void initNavigationView() {
        // 添加侧边菜单的点击事件
        mViewNavigation.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navi_item_moments:
                    showFragment(R.id.flyt_content, new MomentsFragment(), MomentsFragment.TAG);
                    break;
                case R.id.navi_item_settings:
                    showFragment(R.id.flyt_content, new SettingsFragment(), SettingsFragment.TAG);
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

    public MainActivityComponent getComponent() {
        return mMainActivityComponent;
    }

    private void showFragment(@IdRes int container, Fragment fragment, String tag) {
        boolean isShowing = false;

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for (String fragmentTag : mFragmentTags) {
            Fragment frag = getFragmentManager().findFragmentByTag(fragmentTag);
            if (frag != null && !frag.isDetached()) {
                if (fragmentTag.equals(tag)) {
                    // Do nothing
                    isShowing = true;
                } else {
                    fragmentTransaction.detach(frag);
                }
            }
        }

        if (!isShowing) {
            Fragment frag = getFragmentManager().findFragmentByTag(tag);
            if (frag != null) {
                fragmentTransaction.attach(frag);
            } else {
                fragmentTransaction.add(container, fragment, tag);
            }
        }
        fragmentTransaction.commit();
        getFragmentManager().executePendingTransactions();
    }
}