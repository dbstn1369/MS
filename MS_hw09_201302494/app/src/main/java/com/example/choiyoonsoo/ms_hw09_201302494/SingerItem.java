package com.example.choiyoonsoo.ms_hw09_201302494;



public class SingerItem {
    String produce;
    String nameofproduct;
    String what;
    String money;
    int resid;



    public SingerItem(String produce, String nameofproduct,String money, String what,int resid) {
        this.produce = produce;
        this.nameofproduct = nameofproduct;
        this.money = money;
        this.what = what;
        this.resid = resid;

    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }
    public void setProduce(String produce) {
        this.produce = produce;
    }

    public void setNameofproduct(String nameofproduct) {
        this.nameofproduct = nameofproduct;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getProduce() {

        return produce;
    }

    public String getNameofproduct() {
        return nameofproduct;
    }

    public String getWhat() {
        return what;
    }

    public String getMoney() {
        return money;
    }









}
