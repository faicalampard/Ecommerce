package com.sqli.challenge.entities;

public class Capsule extends Product{
    public Capsule(String name, double price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "Capsule";
    }

}
