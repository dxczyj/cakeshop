package com.example.cakeshop.model;


import com.example.cakeshop.utils.PriceUtil;

import java.util.*;


public class Order {
    private int id;
    private float total;//总价
    private int amount;//商品总数
    private int status;//1未付款/2已付款/3已发货/4已完成
    private int paytype;
    private String name;
    private String phone;
    private String address;
    private Date datetime;
    private User user;
    private Map<Integer,Orderitem> orderitemMap = new HashMap<Integer,Orderitem>();
    private List<Orderitem> itemList = new ArrayList<Orderitem>();

    public void setUsername(String username){
        user = new User();
        user.setUsername(username);
    }

    public void addGoods(Goods g){

        if (orderitemMap.containsKey(g.getId())){
            Orderitem item = orderitemMap.get(g.getId());
            item.setAmount(item.getAmount()+1);
        }else{
            Orderitem item = new Orderitem(g.getPrice(),1,g,this);
            orderitemMap.put(g.getId(),item);
        }
        amount++;
        total = PriceUtil.add(total,g.getPrice());

    }
    public void Goodsless(int goodsid){
        if (orderitemMap.containsKey(goodsid)){
            Orderitem item = orderitemMap.get(goodsid);
            item.setAmount(item.getAmount()-1);
            amount--;
            total = PriceUtil.subtract(total,item.getPrice());
            if (item.getAmount()<=0){
                orderitemMap.remove(goodsid);
            }
        }
    }

    public List<Orderitem> getItemList() {
        return itemList;
    }

    public void setItemList(List<Orderitem> itemList) {
        this.itemList = itemList;
    }

    public Map<Integer, Orderitem> getOrderitemMap() {
        return orderitemMap;
    }

    public void setOrderitemMap(Map<Integer, Orderitem> orderitemMap) {
        this.orderitemMap = orderitemMap;
    }

    public Order() {
    }

    public Order(int id, float total, int amount, int status, int paytype, String name, String phone, String address, Date datetime, User user) {
        this.id = id;
        this.total = total;
        this.amount = amount;
        this.status = status;
        this.paytype = paytype;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.datetime = datetime;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
