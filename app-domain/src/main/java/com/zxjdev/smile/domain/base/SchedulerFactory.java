package com.zxjdev.smile.domain.base;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Provide schedulers used in usecases
 */
public class SchedulerFactory {

  private Scheduler uiScheduler;

  public SchedulerFactory(Scheduler uiScheduler) {
    this.uiScheduler = uiScheduler;
  }

  public Scheduler getIoScheduler() {
    return Schedulers.io();
  }

  public Scheduler getUiScheduler() {
    return uiScheduler;
  }

  public Scheduler getComputationScheduler() {
    return Schedulers.computation();
  }
}
