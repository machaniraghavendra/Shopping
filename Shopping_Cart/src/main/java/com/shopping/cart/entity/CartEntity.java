package com.shopping.cart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CartDetails")
public class CartEntity implements Serializable {
    
    @Id
    private int cartId;
    @Column(name = "itemId")
    private int ItemId;
    private String ItemType;
    private String itemName;
    private String ItemImgUrl;
    private String ItemPrice;
    private String ItemDesc;
    private String ItemSpec;
    private String ItemDimensions;
    private String userId;
    
    public int getItemId() {
        return ItemId;
    }
    public void setItemId(int itemId) {
        ItemId = itemId;
    }
    public String getItemType() {
        return ItemType;
    }
    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
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
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public CartEntity(int itemId,int cartId, String itemType, String itemName, String itemImgUrl, String itemPrice,
            String itemDesc, String itemSpec, String itemDimensions, String userId) {
        super();
        ItemId = itemId;
        this.cartId=cartId;
        ItemType = itemType;
        this.itemName = itemName;
        ItemImgUrl = itemImgUrl;
        ItemPrice = itemPrice;
        ItemDesc = itemDesc;
        ItemSpec = itemSpec;
        ItemDimensions = itemDimensions;
        this.userId = userId;
    }
    public CartEntity() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "CartEntity [ItemId=" + ItemId + ", cartId=" + cartId + ", ItemType=" + ItemType + ", itemName="
                + itemName + ", ItemImgUrl=" + ItemImgUrl + ", ItemPrice=" + ItemPrice + ", ItemDesc=" + ItemDesc
                + ", ItemSpec=" + ItemSpec + ", ItemDimensions=" + ItemDimensions + ", userId=" + userId + "]";
    }
  
}