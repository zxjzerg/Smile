package com.zxjdev.smile.domain.user.usecase;

import com.zxjdev.smile.domain.base.SchedulerFactory;
import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.user.UserRepository;

import rx.Observable;

public class GetUser extends UseCase<GetUser.RequestParams, User> {

    private UserRepository userRepository;

    public GetUser(SchedulerFactory schedulerFactory, UserRepository userRepository) {
        super(schedulerFactory);
        this.userRepository = userRepository;
    }

    @Override
    protected Observable<User> buildUseCaseObservable(RequestParams params) {
        return null;
    }

    public static final class RequestParams implements UseCase.RequestParams {

    }
}
