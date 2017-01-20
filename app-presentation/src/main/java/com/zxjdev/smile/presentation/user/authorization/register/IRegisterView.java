package com.zxjdev.smile.presentation.user.authorization.register;

import android.content.Context;

public interface IRegisterView {

    Context context();

    void toast(String message);

    void navigateToMain();
}
