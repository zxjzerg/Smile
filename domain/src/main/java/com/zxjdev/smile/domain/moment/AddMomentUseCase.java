package com.zxjdev.smile.domain.moment;

import com.zxjdev.smile.domain.base.UseCase;
import com.zxjdev.smile.domain.base.UseCaseConfig;

import rx.Observable;

public class AddMomentUseCase extends UseCase {

    private MomentRepository momentRepository;

    private String content;

    public AddMomentUseCase(UseCaseConfig useCaseConfig, MomentRepository momentRepository) {
        super(useCaseConfig);
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
