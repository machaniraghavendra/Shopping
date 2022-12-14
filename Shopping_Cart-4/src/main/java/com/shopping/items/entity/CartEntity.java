package com.shopping.items.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CartDetails")
public class CartEntity {
	
	@Id
	private int ItemId;
	private String ItemType;
	private String itemName;
	private String ItemImgUrl;
	private String ItemPrice;
	private String ItemDesc;
	private String ItemSpec;
	private String ItemDimensions;
	@Override
	public String toString() {
		return "CartEntity [ItemId=" + ItemId + ", ItemType=" + ItemType + ", itemName=" + itemName + ", ItemImgUrl="
				+ ItemImgUrl + ", ItemPrice=" + ItemPrice + ", ItemDesc=" + ItemDesc + ", ItemSpec=" + ItemSpec
				+ ", ItemDimensions=" + ItemDimensions + "]";
	}
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public String getItemType() {
		return ItemType;
	}
	public void setItemType(String itemType) {
		ItemType = itemType;
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
	public String getItemDimensions() {
		return ItemDimensions;
	}
	public void setItemDimensions(String itemDimensions) {
		ItemDimensions = itemDimensions;
	}
	public CartEntity(int itemId, String itemType, String itemName, String itemImgUrl, String itemPrice,
			String itemDesc, String itemSpec, String itemDimensions) {
		super();
		ItemId = itemId;
		ItemType = itemType;
		this.itemName = itemName;
		ItemImgUrl = itemImgUrl;
		ItemPrice = itemPrice;
		ItemDesc = itemDesc;
		ItemSpec = itemSpec;
		ItemDimensions = itemDimensions;
	}
	public CartEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}