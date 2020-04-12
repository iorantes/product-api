package com.test.products.model.service;

import com.test.products.model.dto.ProductDTO;
import com.test.products.model.dto.ResponseDTO;

public interface ProductService {
	
	public ResponseDTO saveProduct(ProductDTO usuaInfo);
	
	public ResponseDTO putProduct(ProductDTO usuaInfo, Long productId);
	
	public ResponseDTO getProduct(Integer page, Integer size);
	
	public ResponseDTO deleteProduct(Long productId);
	
	public ResponseDTO searchProduct(String search, Integer page, Integer size);

}
