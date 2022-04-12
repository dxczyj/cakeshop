package com.example.cakeshop.model;

public class Orderitem {
    private int id;
    private float price;
    private int amount;
    private String goodsName;
    private Goods good;
    private Order order;

    public void setName(String name){
        this.goodsName = name;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Orderitem() {
    }

    public Orderitem(float price, int amount, Goods good, Order order) {
        this.price = price;
        this.amount = amount;
        this.good = good;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
