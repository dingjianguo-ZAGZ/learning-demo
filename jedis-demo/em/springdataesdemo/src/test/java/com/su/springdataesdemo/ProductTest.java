package com.su.springdataesdemo;

import com.su.springdataesdemo.domain.Product;
import com.su.springdataesdemo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;


@SpringBootTest
public class ProductTest {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Test
    public void addProduct(){
        Product product = new Product(1, "iphone30", "苹果最新款手机");
        productRepository.save(product);
    }

}
