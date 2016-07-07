package com.zxjdev.smile.presentation.presenter;

import android.content.Context;
import android.widget.Toast;

import com.avos.avoscloud.AVException;

import rx.Subscriber;
import timber.log.Timber;

public class DefaultSubscriber<T> extends Subscriber<T> {

    private Context context;

    public DefaultSubscriber(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Timber.e(e.getMessage());
        if (e instanceof AVException) {
            AVException avException = (AVException) e;
            int code = avException.getCode();
            String message = avException.getMessage();
            switch (code) {
                case AVException.USERNAME_TAKEN:
                    message = "用户名已经被使用";
                    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    public void onNext(T data) {

    }
}
