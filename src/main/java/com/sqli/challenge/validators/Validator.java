package com.sqli.challenge.validators;

import com.sqli.challenge.EcommerceFacade;
import com.sqli.challenge.entities.Cart;
import com.sqli.challenge.entities.Errors;

public interface Validator {
    Errors validateCart          (Cart cart , String voucher);
}
