package com.example.mettaac.eventconcede.data;

/**
 * Created by JasonLoh95 on 18/12/2017.
 */

public class Member {
    private String name;
    private String Email;
    private String Password;
    private String userName;

    public  Member (){

    }

    public Member (String name, String Email, String userName ){
        this.name = name;
        this.Email =Email;
        this.userName = userName;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return Email;
    }

    private String getPassword(){
        return Password;
    }

    public String getuserName() {
        return userName;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public void setPassword (String Password){
        this.Password = Password;
    }

    public void setuserName(String userName){
        this.userName = userName;
    }

    public boolean authenticateUser (String Email, String password){
        if (this.Email.equals(Email)){
            if(getPassword() == password){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }
}
