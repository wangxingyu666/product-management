package top.wangxingyu.product.api.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.wangxingyu.product.api.entity.Product;
import top.wangxingyu.product.api.service.ProductService;
import top.wangxingyu.product.api.utils.OssUtil;

import java.util.List;


/**
 * @author 笼中雀
 */
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final OssUtil ossUtil;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.list();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean createProduct(@RequestBody Product product){
        return productService.save(product);
    }

    //更新商品
    @PutMapping("/{id}")
    public Boolean updateProduct(@PathVariable Long id,@RequestBody Product product){
        product.setId(id);
        return productService.updateById(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteProduct(@PathVariable Long id){
        return productService.removeById(id);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file")MultipartFile file){
        System.out.println(file.getOriginalFilename());
        return ossUtil.uploadFile(file);
    }
}
