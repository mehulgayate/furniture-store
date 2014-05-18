package com.fns.entity;

import java.sql.Blob;

import javax.persistence.Entity;

import com.evalua.entity.support.EntityBase;

@Entity
public class Product extends EntityBase {

	private String name;
	private Long stock;
	private ProductStatus status;
	private Blob picture;
	private String pictureFileName;
	private String pictureContectType;
	
	
	
	public String getPictureFileName() {
		return pictureFileName;
	}
	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}
	public String getPictureContectType() {
		return pictureContectType;
	}
	public void setPictureContectType(String pictureContectType) {
		this.pictureContectType = pictureContectType;
	}
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

	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}


	public enum ProductStatus{
		AVAILABLE,SUSPENDED,OUT_OF_STOCK;
	}
}
