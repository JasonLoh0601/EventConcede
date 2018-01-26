package com.example.mettaac.eventconcede.data;

/**
 * Created by JasonLoh95 on 6/1/2018.
 */

public class attractionDetail {
    private String attractionName;
    private String hours;
    private String website;
    private String phone;
    private String address;
    private String photo;
    private String price;
    private String payment;

    public attractionDetail(){

    }

    public String getAttractionName(){
        return attractionName;
    }

    public void setAttractionName(String attractionName){
        this.attractionName =attractionName;
    }

    public String getHours(){
        return hours;
    }

    public void setHours(String hours){
        this.hours =hours;
    }

    public String getWebsite(){
        return website;
    }

    public void setWebsite(String website){
        this.website =website;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone =phone;
    }

    public String getAddress(){
        return address;
    }

    public void setAdress(String address){
        this.address =address;
    }

    public String getPhoto(){
        return photo;
    }

    public void setPhoto(String photo){
        this.photo =photo;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price =price;
    }

    public String getPayment(){
        return payment;
    }

    public void setPayment(String payment){
        this.payment =payment;
    }
}
