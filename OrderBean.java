/*
 * @author William Nesham
 * CS4010 HW4
 * date 01/11/2017
 */
package com.nesham;

import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OrderBean implements Serializable {
    
//    //initializes parameters.
//    public static final String urlParameterName = "url";
//    public static final String titleParameterName = "title";
//    public static final String priceParameterName = "price";
//    public static final String selectedParameterName = "checkbox";
//    public static final String PROP_SAMPLE_PROPERTY = "Order was created.";
    
    private PropertyChangeSupport propertySupport;
    private Map<String, ItemBean> cart = new HashMap<String, ItemBean>();
    
    public OrderBean() {
    //    propertySupport = new PropertyChangeSupport(this);
    }

    //gets cart Map
    public Map getCart(){        
        return this.cart;
    }
    
    public void removeItem(ItemBean itemBean) {
        cart.remove(itemBean.getTitle());
    }
    
     public ItemBean getItemByTitle(String title){
        return cart.get(title);
    }
     
    public void addItemToCart(ItemBean itemParm){
        if(itemParm == null) itemParm = new ItemBean();
        ItemBean itemBean = cart.get(itemParm.getTitle());
        if(itemBean == null){
            itemParm.setQuantity(1);
            cart.put(itemParm.getTitle(), itemParm);
        }else {
            itemBean.setQuantity(itemBean.getQuantity()+1);
            
        }
        
    }
    
    
    public PropertyChangeSupport getPropertySupport() {
        return propertySupport;
    }

    public void setPropertySupport(PropertyChangeSupport propertySupport) {
        this.propertySupport = propertySupport;
    }
        
    public void setCart(String names[]) {
        ItemBean itemBean = new ItemBean();
        for(String name : names) {
            this.cart.put(name, itemBean);
        }
        //cart.get("checkbox0").getIsSelected();
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
