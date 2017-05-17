package com.zxjdev.smile.data.moment.entity;

import com.zxjdev.smile.data.user.entity.UserMapper;
import com.zxjdev.smile.domain.common.base.BaseMapper;
import com.zxjdev.smile.domain.moment.Moment;

import javax.inject.Inject;

public class MomentMapper extends BaseMapper<Moment, MomentEntity> {

  private UserMapper userMapper;

  @Inject
  public MomentMapper(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public Moment transform(MomentEntity data) {
    Moment moment = new Moment();
    moment.setId(data.getObjectId());
    moment.setOwner(userMapper.transform(data.getUser()));
    moment.setContent(data.getContent());
    moment.setCreateAt(data.getCreatedAt());
    return moment;
  }
}
