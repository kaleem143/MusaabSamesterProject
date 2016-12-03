package com.example.musaab.musaabproject3;

/**
 * Created by kalim on 12/3/2016.
 */

public class Item {

    String itemName;
    int itemImage;

    public Item(String animalName,int animalImage)
    {
        this.itemImage =animalImage;
        this.itemName =animalName;
    }
    public String getItemName()
    {
        return itemName;
    }
    public int getItemImage()
    {
        return itemImage;
    }
}
