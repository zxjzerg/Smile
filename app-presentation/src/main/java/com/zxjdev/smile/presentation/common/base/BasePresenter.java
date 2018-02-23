package com.zxjdev.smile.presentation.common.base;

/**
 * Base class of all presenters
 */
public interface BasePresenter<T> {

  void takeView(T view);

  void dropView();
}
