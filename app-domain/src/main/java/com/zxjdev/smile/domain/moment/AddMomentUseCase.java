package com.zxjdev.smile.domain.moment;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import rx.Observable;

public class AddMomentUseCase extends UseCase<AddMomentUseCase.RequestParams, Void> {

    private MomentRepository momentRepository;

    public AddMomentUseCase(UseCaseConfig useCaseConfig, MomentRepository momentRepository) {
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
