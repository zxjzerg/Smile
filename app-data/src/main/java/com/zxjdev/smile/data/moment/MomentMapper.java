package com.zxjdev.smile.data.moment;

import com.zxjdev.smile.data.user.UserMapper;
import com.zxjdev.smile.domain.base.BaseMapper;
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
        return moment;
    }
}
