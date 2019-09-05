package com.clay.user.service;

import com.clay.user.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ProductService
 * @Dscription TODO
 * @Author wk
 * @Date 2019/9/3 11:53
 * @Version 1.0
 **/
@FeignClient("PRODUCTSERVICE")
public interface ProductService {

    // 使用请求参数
    @RequestMapping(value = "/products/detail", method = RequestMethod.GET)
    Product loadByName(@RequestParam("name") String name);
    // 使用路径参数
    //@RequestMapping(value = "/products/{itemCode}", method = RequestMethod.GET)
    //Product loadByItemCode(@PathVariable("itemCode") String itemCode);
    // 使用请求头数据
    //@RequestMapping(value = "/products/detail", method = RequestMethod.GET)
    //Product loadByItemCode(@RequestHeader("itemCode") String itemCode);
}
