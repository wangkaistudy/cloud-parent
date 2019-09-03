package com.clay.product.service;

import com.clay.product.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName UserServcie
 * @Dscription 用户接口
 * @Author wk
 * @Date 2019/8/27 10:42
 * @Version 1.0
 **/
@FeignClient("USERSERVICE")
public interface UserServcie {

    // 这里是获取用户列表，注意请求的地址一定要与用户微服务所提供的地址一致
    @GetMapping(value = "/users")
    List<UserDto> findAll();


    @GetMapping("users/{id}")
    UserDto load(@PathVariable("id") Long id);



}
