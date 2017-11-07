package com.example.choiyoonsoo.ms_hw08_201302494;



public class SingerItem {
    String name;
    String mobile;
    String birthday;
    int resId;

    public SingerItem(String name, String mobile, String birthday){
        this.name = name;
        this.mobile = mobile;
        this.birthday = birthday;
    }

    public SingerItem(String name, String mobile, String birthday, int resId){
        this.name =name;
        this.mobile = mobile;
        this.birthday = birthday;
        this.resId = resId;
    }


    public String getBirth(){return birthday;}
    public void setBirth(String birthday){ this.birthday = birthday;}
    public int getResId(){return resId;}
    public void setResId(int resId){this.resId =resId; }
    public  String getMobile(){return mobile;}
    public void setMobile(String mobile){this.mobile = mobile;}

    public String getName(){return name;}
    public void setName(String name){this.name =name;}


}
