package com.shopping.favourites.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FavouritesEntity {

    @Id
    private int favId;
    private int ItemId;
    private String ItemType;
    private String itemName;
    private String ItemImgUrl;
    private String ItemPrice;
    private String ItemDesc;
    private String ItemSpec;
    private String ItemDimensions;
    private String userId;
    
    public FavouritesEntity() {
        super();
        // TODO Auto-generated constructor stub
    }
    public FavouritesEntity(int itemId, int favId, String itemType, String itemName, String itemImgUrl,
            String itemPrice, String itemDesc, String itemSpec, String itemDimensions, String userId) {
        super();
        ItemId = itemId;
        this.favId = favId;
        ItemType = itemType;
        this.itemName = itemName;
        ItemImgUrl = itemImgUrl;
        ItemPrice = itemPrice;
        ItemDesc = itemDesc;
        ItemSpec = itemSpec;
        ItemDimensions = itemDimensions;
        this.userId = userId;
    }
    public int getItemId() {
        return ItemId;
    }
    public void setItemId(int itemId) {
        ItemId = itemId;
    }
    public int getFavId() {
        return favId;
    }
    public void setFavId(int favId) {
        this.favId = favId;
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
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
}
