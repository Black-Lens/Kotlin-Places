package com.blacklenspub.kotlinplaces.data.entity;

public class Place {

    enum Type {
        HOTEL, RESTURANT, SHOPPING, LANDMARK
    }

    private String name;
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
