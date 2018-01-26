package com.example.mettaac.eventconcede.data;

/**
 * Created by JasonLoh95 on 20/12/2017.
 */

public class eventDetail {
    private String eventName;
    private String hours;
    private String website;
    private String address;
    private String photo;
    private String description;
    private String payment;

    public eventDetail(){

    }

    public String getEventName(){
        return eventName;
    }

    public void setEventName(String eventName){
        this.eventName =eventName;
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

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description =description;
    }

    public String getPayment(){
        return payment;
    }

    public void setPayment(String payment){
        this.payment =payment;
    }

    }

