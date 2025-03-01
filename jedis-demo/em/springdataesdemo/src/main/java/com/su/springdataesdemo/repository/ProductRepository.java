package com.su.springdataesdemo.repository;

import com.su.springdataesdemo.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ProductRepository extends ElasticsearchRepository<Product,Integer> {
}
