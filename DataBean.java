
package com.nesham;

import java.util.HashMap;
import java.util.Map;

public class DataBean {
    private Map<String, ItemBean> data;

    public Map<String, ItemBean> getData() {
        return data;
    }
    
    public DataBean() {
        ItemBean i;
        if(data == null)
        {
            data = new HashMap<String, ItemBean>();
            i = new ItemBean();
            i.setPrice("$0.99");
            i.setPriceFloat(.99f);
            i.setTitle("Fox and the Hound");
            i.setQuantity(0);
            i.setUrl("http://t1.gstatic.com/images?q=tbn:ANd9GcS92cjKipIVxLRKnOnJsvbL4rRN0Ckt2kxw88hkSNI03WdyUILa");
            data.put(i.getTitle(), i);

            i = new ItemBean();
            i.setPrice("$2.99");
            i.setPriceFloat(2.99f);
            i.setTitle("Fox and the Hound 2");
            i.setQuantity(0);
            i.setUrl("https://lumiere-a.akamaihd.net/v1/images/open-uri20150422-12561-61bdoq_23c0162f.jpeg");
            data.put(i.getTitle(), i);

            i = new ItemBean();
            i.setPrice("$0.99");
            i.setPriceFloat(.99f);
            i.setTitle("Robin Hood");
            i.setQuantity(0);
            i.setUrl("https://images.store.hmv.com/app_/responsive/HMVStore/media/product/620682/03-620682.jpg?w=500");
            data.put(i.getTitle(), i);            

            i = new ItemBean();
            i.setPrice("$19.99");
            i.setPriceFloat(19.99f);
            i.setTitle("Zootopia");
            i.setQuantity(0);
            i.setUrl("https://images-na.ssl-images-amazon.com/images/I/61z7j30aZsL.jpg");
            data.put(i.getTitle(), i);            
            
        }
    }
    
    public ItemBean getItemByTitle(String title){
        return data.get(title);
    }
}
