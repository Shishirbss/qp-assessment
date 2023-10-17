package com.grocerybooking.dto;

import org.springframework.stereotype.Component;

@Component
public class GroceryDetails {

	private Integer itemCode;
	private String itemName;
	private Double itemPrice;
	private String itemSize;
	private String itemDiscription;
	private String itemCategory;
	private Integer itemQuantity=0;
	
	public Integer getItemCode() {
		return itemCode;
	}
	public void setItemCode(Integer itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	public String getItemDiscription() {
		return itemDiscription;
	}
	public void setItemDiscription(String itemDiscription) {
		this.itemDiscription = itemDiscription;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public Integer getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
}
