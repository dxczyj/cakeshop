package com.example.cakeshop.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Types {
    private int id;
    private String name;

    private String encodeName;

    public String getEncodeName() {
        return encodeName;
    }

    public void setEncodeName(String encodeName) {
        this.encodeName = encodeName;
    }

    public Types() {
    }
    public Types(String name){
        this.name = name;
    }
    public Types(int id, String name) {
        this.id = id;
        this.name = name;
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
        try {
            this.encodeName = URLEncoder.encode(name,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
