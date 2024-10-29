package top.wangxingyu.product.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 笼中雀
 */
@Data
@TableName("product")
public class Product {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String cover;
}