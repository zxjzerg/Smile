package com.zxjdev.smile.domain.base;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public abstract class UseCase<T> {

    private Subscription subscription = Subscriptions.empty();
    private UseCaseConfig useCaseConfig;

    public UseCase(UseCaseConfig useCaseConfig) {
        this.useCaseConfig = useCaseConfig;
    }

    protected abstract Observable<T> buildUseCaseObservable();

    @SuppressWarnings("unchecked")
    public void execute(Subscriber subscriber) {
        this.subscription = this.buildUseCaseObservable()
            .subscribeOn(useCaseConfig.getSubscribeScheduler())
            .observeOn(useCaseConfig.getObserveScheduler())
            .subscribe(subscriber);
    }

    public void unSubscribe() {
        if (!this.subscription.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
    }
}
