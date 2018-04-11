package com.sqli.challenge.presenters;

import com.sqli.challenge.entities.Cart;
import com.sqli.challenge.entities.OrderLine;

import java.io.StringWriter;
import java.util.*;


public class DefaultPresenter implements Presenter {
    @Override
    public String cartContentPresenter(Cart cart) {

        StringWriter out = new StringWriter();

        Map<String, List<OrderLine>> cartByType = cart.groupByTypeOfOrderLine();

        for (Map.Entry<String, List<OrderLine>> productGroup : cartByType.entrySet()) {
            out.append(productGroup.getKey()).append("s\n");
            for (OrderLine orderLine : productGroup.getValue()) {
                out.append(String.format("\tName: %s\tQuantity: %d\tPrice: %.0f\n",
                        orderLine.getProduct().getName(),
                        orderLine.getQuantity(),
                        orderLine.getPrice()) );
            }
        }
        return out.toString();
    }

    @Override
    public String summaryPresenter(Cart cart) {

        StringWriter out = new StringWriter();

        Map<String, List<OrderLine>> cartByType = cart.groupByTypeOfOrderLine();

        for (Map.Entry<String, List<OrderLine>> orderLineGroup : cartByType.entrySet()) {

            out.append(orderLineGroup.getKey()).append("s\n");
            int quantitySum = 0;
            double priceSum = 0;

            for (OrderLine orderLine : orderLineGroup.getValue()) {
                quantitySum += orderLine.getQuantity();
                priceSum += orderLine.getPrice();
            }

            out.append(String.format("\tQuantity: %d\tPrice: %.0f\n", quantitySum, priceSum));
        }
        out.append(String.format("Total Price: %.0f\n", cart.getTotalPrice()));
        return out.toString();
    }
}
