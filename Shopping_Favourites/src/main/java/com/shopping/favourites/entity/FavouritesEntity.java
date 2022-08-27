package com.shopping.favourites.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FavouritesEntity {

	@Id
	private String ItemId;
	private String itemName;
	private String ItemImgUrl;
	private String ItemPrice;
	private String ItemDesc;
	private String ItemSpec;

	public String getItemId() {
		return ItemId;
	}
	public void setItemId(String itemId) {
		ItemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemImgUrl() {
		return ItemImgUrl;
	}
	public void setItemImgUrl(String itemImgUrl) {
		ItemImgUrl = itemImgUrl;
	}
	public String getItemPrice() {
		return ItemPrice;
	}
	public void setItemPrice(String itemPrice) {
		ItemPrice = itemPrice;
	}
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	public String getItemSpec() {
		return ItemSpec;
	}
	public void setItemSpec(String itemSpec) {
		ItemSpec = itemSpec;
	}
	public FavouritesEntity(String itemId, String itemName, String itemImgUrl, String itemPrice, String itemDesc,
			String itemSpec) {
		super();
		ItemId = itemId;
		this.itemName = itemName;
		ItemImgUrl = itemImgUrl;
		ItemPrice = itemPrice;
		ItemDesc = itemDesc;
		ItemSpec = itemSpec;
	}
	public FavouritesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FavouritesEntity [ItemId=" + ItemId + ", itemName=" + itemName + ", ItemImgUrl=" + ItemImgUrl
				+ ", ItemPrice=" + ItemPrice + ", ItemDesc=" + ItemDesc + ", ItemSpec=" + ItemSpec + "]";
	}
	
}
