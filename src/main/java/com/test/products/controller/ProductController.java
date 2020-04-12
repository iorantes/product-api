package com.test.products.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.products.model.dto.ProductDTO;
import com.test.products.model.dto.ResponseDTO;
import com.test.products.model.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping(value = "/saveproducts")
	public ResponseEntity<?> saveUsers(@RequestBody ProductDTO productInfo) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = productService.saveProduct(productInfo);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/getallproducts")
	public ResponseEntity<?> getUsers(@RequestParam Integer page, @RequestParam Integer size) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = productService.getProduct(page, size);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/putproducts")
	public ResponseEntity<?> putUsers(@RequestBody ProductDTO productInfo, @RequestParam Long productId) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = productService.putProduct(productInfo, productId);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/deleteproducts")
	public ResponseEntity<?> deleteUsers(@RequestParam Long productId) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = productService.deleteProduct(productId);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/search")
	public ResponseEntity<?> getSearchName(@RequestParam String search, @RequestParam Integer page, @RequestParam Integer size) {
		ResponseDTO response = new ResponseDTO();
		try {
			response = productService.searchProduct(search, page, size);	
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error en controller getUsers", e);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
