package com.zxjdev.smile.presentation.common.splash;

import android.os.Handler;

import com.zxjdev.smile.domain.user.AutoLoginUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class SplashPresenter {

    private AutoLoginUseCase mAutoLoginUseCase;
    private ISplashView mView;
    private Handler mHandler;

    @Inject
    public SplashPresenter(AutoLoginUseCase autoLoginUseCase, Handler handler) {
        mAutoLoginUseCase = autoLoginUseCase;
        mHandler = handler;
    }

    public void setView(ISplashView view) {
        mView = view;
    }

    public void handleAutoLogin() {
        mAutoLoginUseCase.execute(new DefaultSubscriber<Boolean>(mView.context()) {
            @Override
            public void onNext(Boolean data) {
                if (data) {
                    // 自动登录
                    mHandler.postDelayed(mNavigateToMainTask, 500);
                } else {
                    // 显示登录和注册按钮
                    mView.showButtons();
                }
            }
        });
    }

    public void destroy() {
        mAutoLoginUseCase.unSubscribe();
        mHandler.removeCallbacks(mNavigateToMainTask);
    }

    private Runnable mNavigateToMainTask = new Runnable() {
        @Override
        public void run() {
            mView.navigateToMain();
        }
    };
}
