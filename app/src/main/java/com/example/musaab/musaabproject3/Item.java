package com.example.musaab.musaabproject3;

/**
 * Created by kalim on 12/3/2016.
 */

public class Item {
    int productId;
    String itemName;
    int itemImage;
    double price;

    public Item(int productId, String itemName,int itmeImage)
    {
        this.productId=productId;
        this.itemImage =itmeImage;
        this.itemName =itemName;
    }
    public Item(int productId, String animalName,int itemImage,double price )
    {
        this.productId=productId;
        this.itemImage =itemImage;
        this.itemName =animalName;
        this.price=price;
    }


    public String getItemName()
    {
        return itemName;
    }
    public int getItemImage()
    {
        return itemImage;
    }
    public int getProductId(){return productId;}

 public double getPrice() {return price;}
}
