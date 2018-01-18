package com.example.mettaac.eventconcede.data;

/**
 * Created by JasonLoh95 on 20/12/2017.
 */

public class listViewDetail {
    private String eventName;
    private String price;
    private int photo;

    public listViewDetail(String eventName,String price, int photo){
        this.eventName= eventName;
        this.price =price;
        this.photo = photo;
    }

    public String getEventName (){
        return eventName;
    }

    public void setEventName(String eventName){
        this.eventName = eventName;
    }

    public String getPrice (){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public int getPhoto (){
        return photo;
    }

    public void setPhoto(int photo){
        this.photo = photo;
    }
}
