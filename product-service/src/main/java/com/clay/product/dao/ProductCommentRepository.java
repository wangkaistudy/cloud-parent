package com.clay.product.dao;

import com.clay.product.entity.ProductComment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @ClassName ProductRepository
 * @Dscription TODO
 * @Author wk
 * @Date 2019/8/26 16:10
 * @Version 1.0
 **/
public interface ProductCommentRepository extends PagingAndSortingRepository<ProductComment, Long> {

    List<ProductComment> findByProductIdOrderByCreated(Long id);
}
