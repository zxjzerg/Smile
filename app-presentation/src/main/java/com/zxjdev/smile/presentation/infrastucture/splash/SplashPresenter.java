package com.zxjdev.smile.presentation.infrastucture.splash;

import android.os.Handler;

import com.zxjdev.smile.domain.authorization.usecase.AutoLogin;
import com.zxjdev.smile.presentation.communal.DefaultSubscriber;
import com.zxjdev.smile.presentation.communal.util.ui.ErrorMessagePrinter;

import javax.inject.Inject;

public class SplashPresenter implements SplashContract.Presenter {

  @Inject AutoLogin autoLogin;
  @Inject SplashContract.View view;
  @Inject ErrorMessagePrinter errorMessagePrinter;
  private Handler handler;

  @Inject
  public SplashPresenter() {
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

  @Override
  public void destroy() {
    autoLogin.unSubscribe();
    handler.removeCallbacks(mNavigateToMainTask);
  }

  private Runnable mNavigateToMainTask = new Runnable() {
    @Override
    public void run() {
      view.navigateToMain();
    }
  };
}
