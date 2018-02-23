package com.zxjdev.smile.presentation.infrastucture.splash;

import android.os.Handler;

import com.zxjdev.smile.domain.authorization.usecase.AutoLogin;
import com.zxjdev.smile.presentation.common.DefaultSubscriber;
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

public class SplashPresenter implements SplashContract.Presenter {

  @Inject AutoLogin autoLogin;
  private SplashContract.View view;
  @Inject ErrorMessagePrinter errorMessagePrinter;
  private Handler handler;

  @Inject
  SplashPresenter() {
    this.handler = new Handler();
  }

  @Override
  public void handleAutoLogin() {
    autoLogin.execute(new DefaultSubscriber<Boolean>(errorMessagePrinter) {
      @Override
      public void onNext(Boolean data) {
        if (data) {
          // 自动登录
          handler.postDelayed(mNavigateToMainTask, 500);
        } else {
          // 显示登录和注册按钮
          view.showButtons();
        }
      }
    });
  }

  private Runnable mNavigateToMainTask = new Runnable() {
    @Override
    public void run() {
      view.navigateToMain();
    }
  };

  @Override
  public void takeView(SplashContract.View view) {
    this.view = view;
  }

  @Override
  public void dropView() {
    this.view = null;
    autoLogin.unsubscribe();
    handler.removeCallbacks(mNavigateToMainTask);
  }
}
