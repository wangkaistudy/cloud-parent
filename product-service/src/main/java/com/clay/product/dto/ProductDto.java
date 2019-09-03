package com.clay.product.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName UserDto
 * @Dscription TODO
 * @Author wk
 * @Date 2019/8/22 10:51
 * @Version 1.0
 **/
@Data
@ToString
public class ProductDto {


    private Long id;

    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户头像
     */
    private String avatar;






}
