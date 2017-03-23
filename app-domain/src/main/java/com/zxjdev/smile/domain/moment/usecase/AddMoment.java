package com.zxjdev.smile.domain.moment.usecase;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;
import com.zxjdev.smile.domain.moment.MomentRepository;

import rx.Observable;

public class AddMoment extends UseCase<AddMoment.RequestParams, Void> {

    private MomentRepository momentRepository;

    public AddMoment(UseCaseConfig useCaseConfig, MomentRepository momentRepository) {
        super(useCaseConfig);
        this.momentRepository = momentRepository;
    }

    @Override
    protected Observable<Void> buildUseCaseObservable(RequestParams params) {
        return momentRepository.addMoment(params.getContent());
    }

    public static class RequestParams implements UseCase.RequestParams {

        private String content;

        public RequestParams(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }
}
