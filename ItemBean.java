
package com.nesham;

import java.util.Map;


public class ItemBean {
    private Map<String, OrderBean> cart;
    
    private String url;
    private String title;
    private String price;
    private float priceFloat;
    private int quantity;

    public float getPriceFloat() {
        return priceFloat;
    }
    
    //cart?
    public Map<String, OrderBean> getCart() {
        return cart;
    }

    public void setPriceFloat(float priceFloat) {
        this.priceFloat = priceFloat;
    }
    

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
