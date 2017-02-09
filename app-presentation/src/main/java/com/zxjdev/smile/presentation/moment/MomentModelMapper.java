package com.zxjdev.smile.presentation.moment;

import com.zxjdev.smile.domain.base.BaseMapper;
import com.zxjdev.smile.domain.moment.Moment;

import javax.inject.Inject;

public class MomentModelMapper extends BaseMapper<MomentModel, Moment> {

    @Inject
    public MomentModelMapper() {

    }

    @Override
    public MomentModel transform(Moment data) {
        MomentModel model = new MomentModel();
        model.setContent(data.getContent());
        return model;
    }
}
