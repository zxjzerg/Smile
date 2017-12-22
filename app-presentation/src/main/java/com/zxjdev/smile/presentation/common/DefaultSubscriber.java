package com.zxjdev.smile.presentation.common;

import com.avos.avoscloud.AVException;
import com.zxjdev.smile.presentation.common.util.ui.ErrorMessagePrinter;

import io.reactivex.observers.DisposableObserver;
import timber.log.Timber;

public class DefaultSubscriber<T> extends DisposableObserver<T> {

  private ErrorMessagePrinter errorMessagePrinter;

  public DefaultSubscriber() {
    super();
  }

  public DefaultSubscriber(ErrorMessagePrinter errorMessagePrinter) {
    super();
    this.errorMessagePrinter = errorMessagePrinter;
  }

  @Override
  public void onComplete() {
    
  }

  @Override
  public final void onError(Throwable e) {
    Timber.e(e.getMessage());
    processError(e);
    this.onError();
  }

  public void onError() {

  }

  @Override
  public void onNext(T data) {

  }

  private void processError(Throwable e) {
    if (e instanceof AVException) {
      processNetworkError((AVException) e);
    } else {
      printErrorMessage(e.getMessage());
    }
  }

  private void processNetworkError(AVException e) {
    int code = e.getCode();
    String message = e.getMessage();
    switch (code) {
      case AVException.USERNAME_TAKEN:
        message = "用户名已经被使用";
        printErrorMessage(message);
        break;
      default:
        printErrorMessage(message);
        break;
    }
  }

  private void printErrorMessage(String message) {
    if (errorMessagePrinter != null) errorMessagePrinter.print(message);
  }
}
