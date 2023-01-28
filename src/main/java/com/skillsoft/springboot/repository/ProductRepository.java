package com.skillsoft.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.skillsoft.springboot.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
