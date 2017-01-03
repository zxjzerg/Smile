package com.zxjdev.smile.data.user;

import com.zxjdev.smile.domain.user.User;
import com.zxjdev.smile.domain.base.BaseMapper;

import javax.inject.Inject;

public class UserMapper extends BaseMapper<User, UserEntity> {

    @Inject
    public UserMapper() {

    }

    @Override
    public User transform(UserEntity userEntity) {
        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setNickname(userEntity.getNickName());
        return user;
    }
}
