package com.clay.product.api;

import com.clay.product.dao.ProductCommentRepository;
import com.clay.product.dao.ProductRepository;
import com.clay.product.dto.ProductCommentDto;
import com.clay.product.entity.Product;
import com.clay.product.entity.ProductComment;
import com.clay.product.service.UserServcie;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {
    protected Logger logger = LoggerFactory.getLogger(ProductEndpoint.
    class);
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCommentRepository productCommentRepository;
    // 这里注入了RestTemplate，接下来就可以通过其调用用户微服务了
    @Autowired
    @Qualifier(value = "restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    private UserServcie userServcie;


    /**
    * 获取商品列表
    * @return
    */
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list() {
        return Lists.newArrayList(this.productRepository.findAll());
    }
    /**
    * 获取指定商品的详情
    * @param id 商品的Id
    * @return
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product detail(@PathVariable Long id){
      return this.productRepository.findById(id).get();
    }


    /**
     * 获取商品列表
     * @return
     */
    @GetMapping("/detail")
    public Product list(@RequestParam String itemCode) {
        return this.productRepository.r;
    }

    /**
    * 获取指定商品的评论列表
    * @param id 商品的ID
    * @return
    */
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public List<ProductCommentDto> comments(@PathVariable Long id){
      List<ProductComment> commentList = this.productCommentRepository.findByProductIdOrderByCreated(id);
      if (null == commentList || commentList.isEmpty()){

          return Collections.emptyList();
      }

      return commentList.stream().map((comment) -> {
          ProductCommentDto dto = new ProductCommentDto(comment);
          dto.setProduct(this.productRepository.findById(comment.getProductId()).get());
          dto.setAuthor(this.userServcie.load(comment.getAuthorId()));
          return dto;
      }).collect(Collectors.toList());
  }

}
