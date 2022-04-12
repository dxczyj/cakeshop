package com.example.cakeshop.model;

public class Goods {
    private int id;
    private String name;
    private String image1;
    private String image2;
    private String cover;
    private float price;
    private String intro;
    private Types type;
    private int stock;

    private boolean isScroll;
    private boolean isHot;
    private boolean isNew;

    public boolean getIsScroll() {
        return isScroll;
    }

    public void setScroll(boolean scroll) {
        isScroll = scroll;
    }

    public boolean getIsHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public void setTypeid(int typeid){
        if (type == null){
            type = new Types();
        }
        type.setId(typeid);
    }
    public void setTypename(String typename){
        if (type == null){
            type = new Types();
        }
        type.setName(typename);
    }
    public Goods() {
    }

    public Goods(int id, String name, String image1, String image2, String cover, float price, String intro, Types type) {
        this.id = id;
        this.name = name;
        this.image1 = image1;
        this.image2 = image2;
        this.cover = cover;
        this.price = price;
        this.intro = intro;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public float getPrice() {
        return price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", cover='" + cover + '\'' +
                ", price=" + price +
                ", intro='" + intro + '\'' +
                ", type=" + type +
                '}';
    }
}
