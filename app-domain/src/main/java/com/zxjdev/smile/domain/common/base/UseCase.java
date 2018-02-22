package com.zxjdev.smile.domain.common.base;

import com.zxjdev.smile.domain.common.SchedulerFactory;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
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
  private SchedulerFactory schedulerFactory;

  public UseCase(SchedulerFactory schedulerFactory) {
    this.schedulerFactory = schedulerFactory;
    this.compositeDisposable = new CompositeDisposable();
  }

  protected abstract Observable<T> buildUseCaseObservable(R params);

  public void execute(R params, DisposableObserver<T> observer) {
    compositeDisposable.add(buildUseCaseObservable(params).subscribeOn(getSubscribeOnScheduler())
      .observeOn(getObserveOnScheduler()).subscribeWith(observer));
  }

  public void execute(DisposableObserver<T> observer) {
    execute(null, observer);
  }

  public void unsubscribe() {
    compositeDisposable.dispose();
  }

  protected Scheduler getSubscribeOnScheduler() {
    return schedulerFactory.getIoScheduler();
  }

  protected Scheduler getObserveOnScheduler() {
    return schedulerFactory.getUiScheduler();
  }

  public interface RequestParams {

  }
}
