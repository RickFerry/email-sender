package com.ms.user.controller;

import com.ms.user.dto.UserDto;

import java.util.Collections;
import java.util.List;

public class UserBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static UserDto getDto() {
        UserDto dto = new UserDto();
        dto.setId("1");
        return dto;
    }
}
