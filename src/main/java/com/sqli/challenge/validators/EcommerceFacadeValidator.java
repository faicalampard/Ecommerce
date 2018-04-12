package com.sqli.challenge.validators;

import com.sqli.challenge.EcommerceFacade;
import com.sqli.challenge.entities.Cart;
import com.sqli.challenge.entities.Errors;
import com.sqli.challenge.entities.OrderLine;

import java.util.Map;

public class EcommerceFacadeValidator implements Validator {
    @Override
    public void validate(EcommerceFacade ecommerceFacade) {

        Errors errors = ecommerceFacade.getErrors();
        Cart cart = ecommerceFacade.getCart();
        String voucher = ecommerceFacade.getVoucher();

        if (cart.isEmpty()) {
            errors.add("Empty Cart");
        }

        if (!voucher.isEmpty() && !voucher.matches(".*\\d.*")) {
            errors.add("Invalid voucher code");
        }

        for (Map.Entry<String, OrderLine> orderLineEntry : cart.entrySet()) {
            if (orderLineEntry.getValue().isInValid())
                errors.add(String.format("%s: Invalid Quantity, must be a multiple of 5", orderLineEntry.getKey()));
            if (!voucher.isEmpty() && !orderLineEntry.getValue().canUseVoucher()) {
                errors.add("Voucher requires machine purchase");
                break;
            }
        }
    }
}
