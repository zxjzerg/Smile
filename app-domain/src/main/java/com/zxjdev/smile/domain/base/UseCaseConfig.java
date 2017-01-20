package com.zxjdev.smile.domain.base;

import rx.Scheduler;

public class UseCaseConfig {

    private Scheduler subscribeScheduler;

    private Scheduler observeScheduler;

    public UseCaseConfig(Scheduler subscribeScheduler, Scheduler observeScheduler) {
        this.subscribeScheduler = subscribeScheduler;
        this.observeScheduler = observeScheduler;
    }

    public Scheduler getSubscribeScheduler() {
        return subscribeScheduler;
    }

    public void setSubscribeScheduler(Scheduler subscribeScheduler) {
        this.subscribeScheduler = subscribeScheduler;
    }

    public Scheduler getObserveScheduler() {
        return observeScheduler;
    }

    public void setObserveScheduler(Scheduler observeScheduler) {
        this.observeScheduler = observeScheduler;
    }
}
