package com.zxjdev.smile.domain.common.base;

import io.reactivex.Completable;

/**
 * Super class of all UseCase classes.
 *
 * @param <R> input for this use case
 */
public abstract class JobUseCase<R extends UseCaseRequestParams> {

  protected JobUseCase() {

  }

  protected abstract Completable buildUseCaseObservable(R params);

  public Completable execute(R params) {
    return buildUseCaseObservable(params);
  }
}
