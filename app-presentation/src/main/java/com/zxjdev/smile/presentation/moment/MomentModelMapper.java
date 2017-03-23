package com.zxjdev.smile.presentation.moment;

import com.zxjdev.smile.domain.base.BaseMapper;
import com.zxjdev.smile.domain.moment.Moment;
import com.zxjdev.smile.presentation.user.UserModelMapper;

import javax.inject.Inject;

public class MomentModelMapper extends BaseMapper<MomentModel, Moment> {

  @Inject UserModelMapper userModelMapper;

  @Inject
  public MomentModelMapper() {

  }

  @Override
  public MomentModel transform(Moment data) {
    MomentModel model = new MomentModel();
    model.setOwner(userModelMapper.transform(data.getOwner()));
    model.setContent(data.getContent());
    model.setCreateAt(data.getCreateAt());
    return model;
  }
}
