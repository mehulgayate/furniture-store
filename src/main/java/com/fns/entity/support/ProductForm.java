package com.fns.entity.support;

import java.sql.Blob;

import org.springframework.web.multipart.MultipartFile;

import com.fns.entity.Product.ProductStatus;

public class ProductForm {
	
	private String name;
	private Long stock;
	private ProductStatus status;
	private MultipartFile picture;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public ProductStatus getStatus() {
		return status;
	}
	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	
}
