package com.zxjdev.smile.presentation.common.main;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.soundcloud.android.crop.Crop;
import com.zxjdev.smile.R;
import com.zxjdev.smile.presentation.application.base.activity.BaseDaggerActivity;
import com.zxjdev.smile.presentation.common.main.di.MainActivityComponent;
import com.zxjdev.smile.presentation.common.main.di.MainActivityModule;
import com.zxjdev.smile.presentation.moment.list.MomentListFragment;
import com.zxjdev.smile.presentation.user.UserModel;
import com.zxjdev.smile.presentation.user.settings.SettingsFragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseDaggerActivity implements MainContract.View {

  @BindView(R.id.dlyt_container) DrawerLayout dlytContainer;
  @BindView(R.id.view_toolbar) Toolbar toolbar;
  @BindView(R.id.view_navigation) NavigationView navigationView;
  private ActionBarDrawerToggle drawerToggle;
  private TextView tvUsername;
  private ImageView ivAvatar;

  private List<String> fragmentTags = new ArrayList<>();

  @Inject MainContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    initUi();
    fragmentTags.add(MomentListFragment.TAG);
    fragmentTags.add(SettingsFragment.TAG);

    if (savedInstanceState == null) {
      showFragment(R.id.flyt_content, MomentListFragment.class, MomentListFragment.TAG);
      navigationView.setCheckedItem(R.id.navi_item_moments);
    }

    presenter.onCreate();
  }

  private MainActivityComponent mainActivityComponent;

  @Override
  protected void initDaggerComponent() {
    mainActivityComponent = getActivityComponent().getMainActivityComponent(new MainActivityModule(this));
    mainActivityComponent.inject(this);
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    drawerToggle.syncState();
  }

  @Override
  protected void onDestroy() {
    presenter.onDestroy();
    mainActivityComponent = null;
    super.onDestroy();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

      Uri uri = data.getData();
      cropImage(uri);
    } else if (requestCode == Crop.REQUEST_CROP && resultCode == RESULT_OK) {
      presenter.handleChangeAvatar(outputUri.getPath());
    }
  }

  private String getImagePathFromUri(Uri uri) {
    String[] projection = {MediaStore.Images.Media.DATA};

    Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
    cursor.moveToFirst();

    int columnIndex = cursor.getColumnIndex(projection[0]);
    String picturePath = cursor.getString(columnIndex);
    cursor.close();
    return picturePath;
  }

  private static final String TEMP_AVATAR_FILE_NAME = "avatar.jpg";
  private Uri outputUri;

  private void cropImage(Uri inputUri) {
    File outputFile = new File(context.getCacheDir(), TEMP_AVATAR_FILE_NAME);
    outputUri = Uri.fromFile(outputFile);
    Crop.of(inputUri, outputUri).asSquare().start(this);
  }

  private static int PICK_IMAGE_REQUEST = 1;

  @Override
  public void displayUser(UserModel user) {
    if (navigationView.getHeaderCount() <= 0) return;

    View headerView = navigationView.getHeaderView(0);
    TextView tvUsername = (TextView) headerView.findViewById(R.id.tv_name);
    ImageView ivAvatar = (ImageView) headerView.findViewById(R.id.iv_avatar);

    tvUsername.setText(user.getUsername());
    if (TextUtils.isEmpty(user.getAvatar())) {
      getImageLoader().loadCircleImage(R.drawable.default_avatar, ivAvatar);
    } else {
      getImageLoader().loadCircleImage(user.getAvatar(), ivAvatar);
    }
    ivAvatar.setOnClickListener(v -> {
      Intent intent = new Intent();
      intent.setType("image/*");
      intent.setAction(Intent.ACTION_GET_CONTENT);
      startActivityForResult(intent, PICK_IMAGE_REQUEST);
    });
  }

  @Override
  public void changeUserAvatar(String url) {
    getImageLoader().loadCircleImage(url, ivAvatar);
  }

  /**
   * Get the dagger component of MainActivity. Used in Fragments of MainActivity.
   */
  public MainActivityComponent getComponent() {
    return mainActivityComponent;
  }

  private void initUi() {
    drawerToggle = new ActionBarDrawerToggle(this, dlytContainer, toolbar, R.string.open, R.string.close);

    // handle click event for showing the drawer
    toolbar.setNavigationOnClickListener(v -> dlytContainer.openDrawer(Gravity.LEFT));

    initNavigationView();
  }

  /**
   * Initialize the navigation view in the left drawer.
   */
  private void initNavigationView() {
    navigationView.setNavigationItemSelectedListener(item -> {
      switch (item.getItemId()) {
        case R.id.navi_item_moments:
          showFragment(R.id.flyt_content, MomentListFragment.class, MomentListFragment.TAG);
          break;
        case R.id.navi_item_settings:
          showFragment(R.id.flyt_content, SettingsFragment.class, SettingsFragment.TAG);
          break;
      }
      dlytContainer.closeDrawers();
      return true;
    });
    if (navigationView.getHeaderCount() > 0) {
      View headerView = navigationView.getHeaderView(0);
      tvUsername = (TextView) headerView.findViewById(R.id.tv_name);
      ivAvatar = (ImageView) headerView.findViewById(R.id.iv_avatar);
    }
  }

  /**
   * Display a certain fragment.
   *
   * @param container resource id of the container
   * @param cls class of the fragment to show
   * @param tag unique tag of the fragment
   */
  private void showFragment(@IdRes int container, Class<? extends Fragment> cls, String tag) {
    boolean isShowing = false;
    FragmentManager fragmentManager = super.getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    for (String fragmentTag : fragmentTags) {
      Fragment frag = fragmentManager.findFragmentByTag(fragmentTag);
      if (frag != null && !frag.isHidden()) {
        if (fragmentTag.equals(tag)) {
          // Do nothing
          isShowing = true;
        } else {
          fragmentTransaction.hide(frag);
        }
      }
    }

    if (!isShowing) {
      Fragment frag = fragmentManager.findFragmentByTag(tag);
      if (frag != null) {
        fragmentTransaction.show(frag);
      } else {
        frag = Fragment.instantiate(context, cls.getName());
        fragmentTransaction.add(container, frag, tag);
      }
    }
    fragmentTransaction.commit();
    getFragmentManager().executePendingTransactions();
  }
}