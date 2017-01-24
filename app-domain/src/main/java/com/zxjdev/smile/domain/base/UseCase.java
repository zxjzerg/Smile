package com.zxjdev.smile.domain.base;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Super class of all UseCase classes.
 *
 * @param <T> the return data type of this UseCase
 */
public abstract class UseCase<R extends UseCase.RequestParams, T> {

    private Subscription subscription = Subscriptions.empty();
    private UseCaseConfig useCaseConfig;

    public UseCase(UseCaseConfig useCaseConfig) {
        this.useCaseConfig = useCaseConfig;
    }

    protected abstract Observable<T> buildUseCaseObservable(R params);

    @SuppressWarnings("unchecked")
    public void execute(R params, Subscriber<T> subscriber) {
        this.subscription = this.buildUseCaseObservable(params)
            .subscribeOn(useCaseConfig.getSubscribeScheduler())
            .observeOn(useCaseConfig.getObserveScheduler())
            .subscribe(subscriber);
    }

    public void execute(Subscriber<T> subscriber) {
        this.subscription = this.buildUseCaseObservable(null)
            .subscribeOn(useCaseConfig.getSubscribeScheduler())
            .observeOn(useCaseConfig.getObserveScheduler())
            .subscribe(subscriber);
    }

    public void unSubscribe() {
        if (!this.subscription.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
    }

    public interface RequestParams {

    }
}
