package com.sqli.challenge.validators;

import com.sqli.challenge.EcommerceFacade;
import com.sqli.challenge.entities.Cart;
import com.sqli.challenge.entities.Errors;
import com.sqli.challenge.entities.OrderLine;
import com.sqli.challenge.entities.Product;

import java.util.Map;

public class DefaultValidator implements Validator {
    @Override
    public Errors validateCart(Cart cart , String voucher) {

        Errors errors = new Errors();

        if (cart.isEmpty()) {
            errors.add("Empty Cart");
        }

        if (!voucher.isEmpty() && !voucher.matches(".*\\d.*")) {
            errors.add("Invalid voucher code");
        }

        for (Map.Entry<String, OrderLine> productEntry : cart.entrySet()) {
            if (productEntry.getValue().isInValid())
                errors.add(String.format("%s: Invalid Quantity, must be a multiple of 5", productEntry.getKey()));
            if (!voucher.isEmpty() && !productEntry.getValue().canUseVoucher()) {
                errors.add("Voucher requires machine purchase");
                break;
            }
        }
        return errors;
    }
}
