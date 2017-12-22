package com.zxjdev.smile.domain.common;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

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
