package com.example.marketapp;

public class ItemClass {
    private int itemimage;
    private String itemname;
    private String itemdesc;

    public ItemClass(int itemimage, String itemname, String itemdesc) {
        setItemdesc(itemdesc);
        setItemimage(itemimage);
        setItemname(itemname);
    }

    public int getItemimage() {
        return itemimage;
    }

    public void setItemimage(int itemimage) {
        this.itemimage = itemimage;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }
}
