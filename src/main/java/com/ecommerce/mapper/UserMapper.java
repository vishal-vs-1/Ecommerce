package com.ecommerce.mapper;

import com.ecommerce.entity.User;
import com.ecommerce.requests.RegistrationRequest;

public class UserMapper {

    public static User registerUserMapper(RegistrationRequest req){

        return User.builder()
                .email(req.getEmail())
                .name(req.getName())
                .password(req.getPassword())
                .phoneNo(req.getPhoneNo())
                .build();
    }


}
