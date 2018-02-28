package com.zxjdev.smile.data.base;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Base class of all the data repositories
 **/
public abstract class BaseDataRepository {

  protected <T> ObservableTransformer<T, T> applyDefaultSchedulerStrategy() {
    return upstream -> upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }
}
