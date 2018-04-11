package com.sqli.challenge.entities;

public class Machine extends Product {

    public Machine(String name, double price) {
        super(name, price);
    }

    @Override
    public String getType() {
        return "Machine";
    }

}
