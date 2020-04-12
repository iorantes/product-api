package com.test.products.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CTG_PRODUCT")
public class Product extends AbstractBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -500573544750236744L;

	@Id
	@Column(name = "CTG_PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long producId;

	@Column(name = "CTG_PRODUCT_NAME", nullable = false)
	private String producName;

	@Column(name = "CTG_PRODUCT_QUANTITY", nullable = false)
	private Integer producQuantity;

	@Column(name = "CTG_PRODUCT_PRICE", nullable = false)
	private Double producPrice;

	@Column(name = "CTG_PRODUCT_DESCRIPTION")
	private String producDescr;

	@Column(name = "CTG_PRODUCT_SKU")
	private Integer productSKU;

	@Column(name = "CTG_PRODUCT_IMAGE")
	private byte[] producImage;

	@Column(name = "CTG_PRODUCT_ACTIVE")
	private Integer producActive;

	public Long getProducId() {
		return producId;
	}

	public void setProducId(Long producId) {
		this.producId = producId;
	}

	public String getProducName() {
		return producName;
	}

	public void setProducName(String producName) {
		this.producName = producName;
	}

	public Integer getProducQuantity() {
		return producQuantity;
	}

	public void setProducQuantity(Integer producQuantity) {
		this.producQuantity = producQuantity;
	}

	public Double getProducPrice() {
		return producPrice;
	}

	public void setProducPrice(Double producPrice) {
		this.producPrice = producPrice;
	}

	public String getProducDescr() {
		return producDescr;
	}

	public void setProducDescr(String producDescr) {
		this.producDescr = producDescr;
	}

	public Integer getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(Integer productSKU) {
		this.productSKU = productSKU;
	}

	public byte[] getProducImage() {
		return producImage;
	}

	public void setProducImage(byte[] producImage) {
		this.producImage = producImage;
	}

	public Integer getProducActive() {
		return producActive;
	}

	public void setProducActive(Integer producActive) {
		this.producActive = producActive;
	}

	public Product() {
		super();
	}

	public Product(Long producId, String producName, Integer producQuantity, Double producPrice, String producDescr,
			Integer productSKU, byte[] producImage, Integer producActive) {
		super();
		this.producId = producId;
		this.producName = producName;
		this.producQuantity = producQuantity;
		this.producPrice = producPrice;
		this.producDescr = producDescr;
		this.productSKU = productSKU;
		this.producImage = producImage;
		this.producActive = producActive;
	}

}
