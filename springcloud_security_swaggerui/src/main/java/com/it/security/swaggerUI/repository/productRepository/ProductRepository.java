package com.it.security.swaggerUI.repository.productRepository;

import com.it.security.swaggerUI.pojo.product.Product;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
