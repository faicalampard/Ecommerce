package com.sqli.challenge;

import com.sqli.challenge.entities.Cart;
import com.sqli.challenge.entities.Errors;
import com.sqli.challenge.presenters.DefaultPresenter;
import com.sqli.challenge.presenters.Presenter;
import com.sqli.challenge.validators.DefaultValidator;
import com.sqli.challenge.validators.Validator;

public class EcommerceFacade {

    private Cart cart = new Cart();
    private Errors errors = new Errors();
    private String voucher = "";
    private Validator validator = new DefaultValidator();
    private Presenter presenter = new DefaultPresenter();

    public void addMachine(String name, int quantity, int price) {
        cart.addOrderLine("MACHINE", name, quantity, price);
    }

    public void addCapsule(String name, int quantity, int price) {
        cart.addOrderLine("CAPSULE", name, quantity, price);
    }

    public void removeMachine(String name, int quantity) {
        cart.removeOrderLine(name, quantity);
    }

    public void removeCapsule(String name, int quantity) {
        cart.removeOrderLine(name, quantity);
    }

    public String cartContent() {
        return presenter.cartContentPresenter(cart);
    }

    public String summary() {
        return presenter.summaryPresenter(cart);
    }

    public EcommerceFacade order() {
        errors = validator.validateCart(cart, voucher);
        return this;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String errors() {
        return String.join("\n", errors);
    }

    public void voucher(String voucher) {
        this.voucher = voucher;
    }
}
