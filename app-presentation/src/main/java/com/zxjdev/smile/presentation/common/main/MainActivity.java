package com.zxjdev.smile.presentation.common.main;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.activity.BaseActivity;
import com.zxjdev.smile.presentation.common.main.di.MainActivityComponent;
import com.zxjdev.smile.presentation.common.main.di.MainActivityModule;
import com.zxjdev.smile.presentation.moment.list.MomentListFragment;
import com.zxjdev.smile.presentation.user.UserModel;
import com.zxjdev.smile.presentation.user.settings.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.dlyt_container) DrawerLayout dlytContainer;
    @BindView(R.id.view_toolbar) Toolbar toolbar;
    @BindView(R.id.view_navigation) NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private TextView tvUsername;

    private MainActivityComponent mainActivityComponent;

    private List<String> fragmentTags = new ArrayList<>();

    @Inject MainContract.Presenter mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUi();
        fragmentTags.add(MomentListFragment.TAG);
        fragmentTags.add(SettingsFragment.TAG);

        if (savedInstanceState == null) {
            showFragment(R.id.flyt_content, new MomentListFragment(), MomentListFragment.TAG);
            navigationView.setCheckedItem(R.id.navi_item_moments);
        }
    }

    @Override
    protected void initializeInjector() {
        mainActivityComponent = getActivityComponent().getMainActivityComponent(
            new MainActivityModule(this));
        mainActivityComponent.inject(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    protected void onDestroy() {
        mainActivityComponent = null;
        super.onDestroy();
    }

    private void initUi() {
        drawerToggle = new ActionBarDrawerToggle(this, dlytContainer, toolbar, R.string.open,
            R.string.close);

        // disable the default implementation of ActionBarDrawerToggle adding a navigationView icon to
        // the Toolbar, because we cannot change the icon style
        drawerToggle.setDrawerIndicatorEnabled(false);
        // set custom navigationView icon in the ToolBar
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        // handle click event for showing the drawer
        toolbar.setNavigationOnClickListener(v -> dlytContainer.openDrawer(Gravity.LEFT));

        initNavigationView();
    }

    private void initNavigationView() {
        // 添加侧边菜单的点击事件
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navi_item_moments:
                    showFragment(R.id.flyt_content, new MomentListFragment(),
                        MomentListFragment.TAG);
                    break;
                case R.id.navi_item_settings:
                    showFragment(R.id.flyt_content, new SettingsFragment(), SettingsFragment.TAG);
                    break;
            }
            dlytContainer.closeDrawers();
            return true;
        });

        if (navigationView.getHeaderCount() > 0) {
            View view = navigationView.getHeaderView(0);
            tvUsername = (TextView) view.findViewById(R.id.tv_name);
            tvUsername.setText("username");
        }
    }

    public MainActivityComponent getComponent() {
        return mainActivityComponent;
    }

    private void showFragment(@IdRes int container, Fragment fragment, String tag) {
        boolean isShowing = false;

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        for (String fragmentTag : fragmentTags) {
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

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void displayUser(UserModel user) {

    }
}