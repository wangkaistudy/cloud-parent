package com.clay.product.service.impl;

import com.clay.product.dto.UserDto;
import com.clay.product.service.UserServcie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Dscription TODO
 * @Author wk
 * @Date 2019/9/4 20:40
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserServcie {

    @Autowired
    private RestTemplate restTemplate;




    // 这里是通过restTemplate获取全部用户信息，并声明降级方法findAllFallback
    @Override
    @HystrixCommand(fallbackMethod = "findAllFallback")
    public List<UserDto> findAll() {
        UserDto[] userDtos = this.restTemplate.getForObject(
                "http://USERSERVICE/users/", UserDto[].class);
        return Arrays.asList(userDtos);
    }
    // 这里是查询一个具体用户的方法，降级方法是loadFallback
    @Override
    @HystrixCommand(fallbackMethod = "loadFallback")
    public UserDto load(Long id) {
        return this.restTemplate.getForEntity(
                "http://USERSERVICE/users/" + id,
                UserDto.class).getBody();
    }
    // 该方法是findAll方法的降级方法，当restTemplate无法访问到USERSERVICE时
    // 调用该方法返回一组固定的用户信息
    protected List<UserDto> findAllFallback() {
        List<UserDto> userDtos = new ArrayList<>();
        userDtos.add(new UserDto(1L, "zhangSan_static", "/users/avatar/zhangsan.png"));
        // 这里忽略了部分代码，具体可以参考本书的源代码
        return userDtos;
    }
    // 该方法是load方法的降级方法，当restTemplate无法访问到USERSERVICE时
    // 调用该方法返回一个匿名用户信息
    protected UserDto loadFallback(Long id) {
        return new UserDto(id, "Anonymous_static", "default.png");
    }
}

