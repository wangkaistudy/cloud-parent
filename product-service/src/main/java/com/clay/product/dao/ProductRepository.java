package com.clay.product.dao;

import com.clay.product.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @ClassName ProductRepository
 * @Dscription TODO
 * @Author wk
 * @Date 2019/8/26 16:10
 * @Version 1.0
 **/
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
