package com.clay.user.dto;

import com.clay.user.entity.User;
import lombok.Data;

/**
 * @ClassName UserDto
 * @Dscription TODO
 * @Author wk
 * @Date 2019/8/22 10:51
 * @Version 1.0
 **/

@Data
public class UserDto extends User {

    private Integer userServicePort;

    public UserDto(User user,Integer userServicePort) {
        super(user);
        this.userServicePort = userServicePort;
    }


}
