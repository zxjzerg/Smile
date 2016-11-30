package com.zxjdev.smile.domain.interactor;

import com.zxjdev.smile.domain.repository.MomentRepository;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

public class AddMomentUseCase extends UseCase {

    private MomentRepository momentRepository;

    private String content;

    @Inject
    public AddMomentUseCase(Scheduler postExecutionThread, MomentRepository momentRepository) {
        super(postExecutionThread);
        this.momentRepository = momentRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return momentRepository.addMoment(this.content);
    }

    public void setInput(String content) {
        this.content = content;
    }
}
