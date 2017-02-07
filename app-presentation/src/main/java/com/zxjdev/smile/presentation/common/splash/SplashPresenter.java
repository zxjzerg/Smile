package com.zxjdev.smile.presentation.common.splash;

import android.os.Handler;

import com.zxjdev.smile.domain.user.AutoLoginUseCase;
import com.zxjdev.smile.presentation.application.DefaultSubscriber;

import javax.inject.Inject;

public class SplashPresenter implements SplashContract.Presenter {

    private AutoLoginUseCase autoLoginUseCase;
    private SplashContract.View view;
    private Handler handler;

    @Inject
    public SplashPresenter(SplashContract.View view, AutoLoginUseCase autoLoginUseCase) {
        this.view = view;
        this.autoLoginUseCase = autoLoginUseCase;
        this.handler = new Handler();
    }

    @Override
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

    @Override
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
