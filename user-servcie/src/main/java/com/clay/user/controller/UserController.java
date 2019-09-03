package com.clay.user.controller;

import com.clay.user.dto.UserDto;
import com.clay.user.entity.User;
import com.clay.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UserController
 * @Dscription TODO
 * @Author wk
 * @Date 2019/8/22 14:58
 * @Version 1.0
 **/
@RestController
@RequestMapping("/users")

public class UserController {


    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private Integer servicePort;


    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> findAll(Pageable pageable) {
        Page<User> page = this.userService.getPage(pageable);
        if (null!= page){
            // 转换成DTO对象
            return page.getContent().stream().map((user) -> {
                return new UserDto(user,servicePort);
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto detail(@PathVariable Long id) {
        User user = this.userService.load(id);
        return (null!= user) ?new UserDto(user,servicePort) :null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public UserDto update(@PathVariable Long id,
                          @RequestBody UserDto userDto) {
        userDto.setId(id);
        User user = this.userService.save(userDto);
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Long id) {
        this.userService.delete(id);
        return true;
    }
}


