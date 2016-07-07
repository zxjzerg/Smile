package com.zxjdev.smile.presentation.view.i.authorization;

import android.content.Context;

public interface IRegisterView {

    Context context();

    void toast(String message);

    void navigateToMain();
}
