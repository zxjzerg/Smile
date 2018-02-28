package com.zxjdev.smile.domain.common.base;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Super class of all UseCase classes.
 *
 * @param <R> input for this use case
 * @param <T> the return data type of this UseCase
 */
public abstract class UseCase<R extends UseCase.RequestParams, T> {

  private CompositeDisposable compositeDisposable;

  public UseCase() {
    this.compositeDisposable = new CompositeDisposable();
  }

  protected abstract Observable<T> buildUseCaseObservable(R params);

  public void execute(R params, DisposableObserver<T> observer) {
    compositeDisposable.add(buildUseCaseObservable(params).subscribeWith(observer));
  }

  public void execute(DisposableObserver<T> observer) {
    execute(null, observer);
  }

  public void unsubscribe() {
    compositeDisposable.dispose();
  }

  public interface RequestParams {

  }
}
