package com.sqli.challenge.entities;

public class OrderLine {

    private final Product product;
    private int quantity;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void deductQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public double getPrice() {
        return quantity * product.getPrice();
    }

    public String getProductType() {
        return product.getType();
    }

    public boolean isInValid() {
        return product.getType().equals("Capsule") & quantity % 5 != 0;
    }


    public boolean canUseVoucher() {
        return product.getType().equals("Machine");
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
