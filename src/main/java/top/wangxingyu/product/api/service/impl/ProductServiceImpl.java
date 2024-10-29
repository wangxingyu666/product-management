package top.wangxingyu.product.api.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wangxingyu.product.api.entity.Product;
import top.wangxingyu.product.api.mapper.ProductMapper;
import top.wangxingyu.product.api.service.ProductService;

/**
 * @author 笼中雀
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
