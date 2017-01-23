package com.zxjdev.smile.presentation.common.splash;

import android.os.Handler;

import com.zxjdev.smile.domain.user.AutoLoginUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class SplashPresenter {

    private AutoLoginUseCase autoLoginUseCase;
    private SplashView view;
    private Handler handler;

    @Inject
    public SplashPresenter(AutoLoginUseCase autoLoginUseCase) {
        this.autoLoginUseCase = autoLoginUseCase;
        this.handler = new Handler();
    }

    public void setView(SplashView view) {
        this.view = view;
    }

    public void handleAutoLogin() {
        autoLoginUseCase.execute(new DefaultSubscriber<Boolean>(view.context()) {
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

    public void destroy() {
        autoLoginUseCase.unSubscribe();
        handler.removeCallbacks(mNavigateToMainTask);
    }

    private Runnable mNavigateToMainTask = new Runnable() {
        @Override
        public void run() {
            view.navigateToMain();
        }
    };
}
