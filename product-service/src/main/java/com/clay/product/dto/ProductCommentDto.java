package com.clay.product.dto;

import com.clay.product.entity.Product;
import com.clay.product.entity.ProductComment;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @ClassName UserDto
 * @Dscription TODO
 * @Author wk
 * @Date 2019/8/22 10:51
 * @Version 1.0
 **/
@Data
@ToString
public class ProductCommentDto {


    /** 商品评论数据库主键 */
    private Long id;
    /** 所示商品的ID */
    private Long productId;
    /** 评论作者的ID */
    private Long authorId;
    /** 评论的具体内容 */
    private String content;
    /** 评论创建时间 */
    private Date created;

    private Product product;

    private UserDto author;

    public ProductCommentDto(ProductComment comment) {
        BeanUtils.copyProperties(comment, this);
    }
}
