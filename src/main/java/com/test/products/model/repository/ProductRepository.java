package com.test.products.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.products.model.entity.Product;

public interface ProductRepository extends AbstractBaseRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.producActive = 1")
	public Page<Product> findAll(Pageable pageable);

	@Query("SELECT p FROM Product p WHERE p.producActive = 1 AND (p.producName LIKE %:search% OR p.productSKU LIKE %:search%)")
	public Page<Product> searchProduct(@Param(value = "search") String search, Pageable pageable);

}
