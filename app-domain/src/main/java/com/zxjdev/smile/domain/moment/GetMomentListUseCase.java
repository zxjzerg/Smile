package com.zxjdev.smile.domain.moment;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import java.util.List;

import rx.Observable;

public class GetMomentListUseCase
    extends UseCase<GetMomentListUseCase.RequestParams, List<Moment>> {

    private MomentRepository momentRepository;

    public GetMomentListUseCase(UseCaseConfig useCaseConfig, MomentRepository momentRepository) {
        super(useCaseConfig);
        this.momentRepository = momentRepository;
    }

    @Override
    protected Observable<List<Moment>> buildUseCaseObservable(RequestParams params) {
        return momentRepository.queryMomentList();
    }

    public static class RequestParams implements UseCase.RequestParams {

    }
}