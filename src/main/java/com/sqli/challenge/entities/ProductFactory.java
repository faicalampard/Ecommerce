package com.sqli.challenge.entities;

public class ProductFactory {
    public Product getProduct (String type , String name , double price) {
        switch (type) {
            case "MACHINE" : return new Machine(name , price);
            case "CAPSULE" : return new Capsule(name , price);
            default        : return null;
        }
    }
}
