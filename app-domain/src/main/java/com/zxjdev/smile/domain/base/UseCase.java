package com.zxjdev.smile.domain.base;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Super class of all UseCase classes.
 *
 * @param <R> input for this use case
 * @param <T> the return data type of this UseCase
 */
public abstract class UseCase<R extends UseCase.RequestParams, T> {

    private Subscription subscription = Subscriptions.empty();
    private SchedulerFactory schedulerFactory;

    public UseCase(SchedulerFactory schedulerFactory) {
        this.schedulerFactory = schedulerFactory;
    }

    protected abstract Observable<T> buildUseCaseObservable(R params);

    public void execute(R params, Subscriber<T> subscriber) {
        this.subscription = this.buildUseCaseObservable(params)
            .subscribeOn(getSubscribeOnScheduler())
            .observeOn(getObserveOnScheduler())
            .subscribe(subscriber);
    }

    public void execute(Subscriber<T> subscriber) {
        this.subscription = this.buildUseCaseObservable(null)
            .subscribeOn(getSubscribeOnScheduler())
            .observeOn(getObserveOnScheduler())
            .subscribe(subscriber);
    }

    public void unSubscribe() {
        if (!this.subscription.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
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
