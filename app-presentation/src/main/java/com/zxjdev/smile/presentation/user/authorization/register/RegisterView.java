package com.zxjdev.smile.presentation.user.authorization.register;

import android.content.Context;

public interface RegisterView {

    Context context();

    void toast(String message);

    void navigateToMain();
}
