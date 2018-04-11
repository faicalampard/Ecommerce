package com.sqli.challenge.entities;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Cart extends TreeMap<String , OrderLine> {

    private ProductFactory productFactory = new ProductFactory();

    public void addOrderLine(String type, String name, int quantity, double price) {

        Product product = productFactory.getProduct(type, name, price);
        OrderLine orderLine = new OrderLine(product , quantity);
        this.merge(product.getName(),
                orderLine,
                (oldOrderLine, newOrderLine) -> {
                    oldOrderLine.addQuantity(newOrderLine.getQuantity());
                    return oldOrderLine;
                });
    }

    public void removeOrderLine(String name, int quantity) {
        OrderLine orderLine = this.get(name);
        orderLine.deductQuantity(quantity);
    }

    public double getTotalPrice() {
        return this.values().stream().mapToDouble(OrderLine::getPrice).sum();
    }

    public Map<String, List<OrderLine>> groupByTypeOfOrderLine () {
        return this.entrySet().stream().map(Map.Entry::getValue)
                .collect(groupingBy(OrderLine::getProductType, TreeMap::new, Collectors.toList()));
    }
}
