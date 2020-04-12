package com.test.products.model.dto;

public class ProductDTO {

	private String name;
	private Integer quantity;
	private Double price;
	private String descrip;
	private Integer sku;
	private byte[] img;
	private Integer active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public ProductDTO() {
		super();
	}

	public ProductDTO(String name, Integer quantity, Double price, String descrip, Integer sku, byte[] img,
			Integer active) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.descrip = descrip;
		this.sku = sku;
		this.img = img;
		this.active = active;
	}

}
