package com.zxjdev.smile.domain.common.base;

import io.reactivex.Observable;

/**
 * Super class of all UseCase classes.
 *
 * @param <R> input for this use case
 * @param <T> the return data type of this UseCase
 */
public abstract class DataUseCase<R extends UseCaseRequestParams, T> {

  public DataUseCase() {

  }

  protected abstract Observable<T> buildUseCaseObservable(R params);

  public Observable<T> execute(R params) {
    return buildUseCaseObservable(params);
  }

  public Observable<T> execute() {
    return buildUseCaseObservable(null);
  }
}
