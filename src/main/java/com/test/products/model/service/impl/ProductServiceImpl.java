package com.test.products.model.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.products.model.dto.ProductDTO;
import com.test.products.model.dto.ResponseDTO;
import com.test.products.model.entity.Product;
import com.test.products.model.repository.ProductRepository;
import com.test.products.model.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepo;

	@Override
	public ResponseDTO saveProduct(ProductDTO productInfo) {

		ResponseDTO response = new ResponseDTO();

		try {

			Product product = new Product();

			product = new Product(null, productInfo.getName(), productInfo.getQuantity(), productInfo.getPrice(),
					productInfo.getDescrip(), productInfo.getSku(), productInfo.getImg(), productInfo.getActive());
			productRepo.save(product);
			logger.info("Producto guardado");
			response = new ResponseDTO(ResponseDTO.CODE_OK, ResponseDTO.MSG_OK);

		} catch (Exception e) {
			logger.error("Error al guardar Usuario", e);
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL);
		}
		return response;
	}

	@Override
	public ResponseDTO putProduct(ProductDTO productInfo, Long productId) {
		ResponseDTO response = new ResponseDTO();

		try {

			Product product = new Product();
			product = productRepo.findById(productId).orElse(null);
			if (null != product) {
				logger.info("Obteniendo producto registrado");
				product = new Product(product.getProducId(), productInfo.getName(), productInfo.getQuantity(),
						productInfo.getPrice(), productInfo.getDescrip(), productInfo.getSku(), productInfo.getImg(),
						productInfo.getActive());
				productRepo.save(product);
				logger.info("Producto actualizado");
				response = new ResponseDTO(ResponseDTO.CODE_OK, ResponseDTO.MSG_OK);
			} else {
				response = new ResponseDTO(ResponseDTO.CODE_USER_NOTFOUND, ResponseDTO.MSG_USER_NOTFOUND);
			}
		} catch (Exception e) {
			logger.error("Error al actualizar Producto");
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL);
		}
		return response;
	}

	@Override
	public ResponseDTO getProduct(Integer page, Integer size) {
		ResponseDTO response = new ResponseDTO();
		try {
			Pageable pageable = PageRequest.of((page - 1), size);
			Page<Product> product = productRepo.findAll(pageable);
			logger.info("Obteniendo la lista paginada de Productos");
			response.setCode(ResponseDTO.CODE_OK);
			response.setMessage(ResponseDTO.MSG_OK);
			response.setResponse(product);
		} catch (Exception e) {
			logger.error("Error obteniendo la lista de usuarios", e);
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL);
		}
		return response;
	}

	@Override
	public ResponseDTO deleteProduct(Long productId) {
		ResponseDTO response = new ResponseDTO();

		try {

			Product product = new Product();
			product = productRepo.findById(productId).orElse(null);
			if (null != product) {
				logger.info("Obteniendo producto registrado");
				product.setProducActive(0);
				productRepo.save(product);
				logger.info("Producto eliminado");
				response = new ResponseDTO(ResponseDTO.CODE_OK, ResponseDTO.MSG_OK);
			} else {
				response = new ResponseDTO(ResponseDTO.CODE_USER_NOTFOUND, ResponseDTO.MSG_USER_NOTFOUND);
			}
		} catch (Exception e) {
			logger.error("Error al eliminar Producto");
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL);
		}
		return response;
	}

	@Override
	public ResponseDTO searchProduct(String search, Integer page, Integer size) {
		ResponseDTO response = new ResponseDTO();
		try {
			Pageable pageable = PageRequest.of((page - 1), size);
			Page<Product> product = productRepo.searchProduct(search, pageable);
			logger.info("Obteniendo la lista paginada de busqueda de Productos");
			response.setCode(ResponseDTO.CODE_OK);
			response.setMessage(ResponseDTO.MSG_OK);
			response.setResponse(product);
		} catch (Exception e) {
			logger.error("Error obteniendo la lista de usuarios", e);
			response = new ResponseDTO(ResponseDTO.CODE_FATAL, ResponseDTO.MSG_FATAL);
		}
		return response;
	}

}
