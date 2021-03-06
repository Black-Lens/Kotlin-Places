package com.blacklenspub.kotlinplaces.data.entity;

public class Place {

    public enum Type {
        HOTEL, RESTAURANT, SHOPPING, LANDMARK
    }

    private String name;
    private Type type;

    public Place(String name, Type type) {
        this.name = name;
        this.type = type;
    }

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
