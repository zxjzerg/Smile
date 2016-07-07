package com.zxjdev.smile.data.entity.mapper;

import com.zxjdev.smile.data.entity.UserEntity;
import com.zxjdev.smile.domain.bo.User;

public class UserMapper {

    public static User transform(UserEntity userEntity) {
        User user = new User();
        user.setUsername(userEntity.getUsername());
        user.setNickname(userEntity.getNickName());

        return user;
    }
}
