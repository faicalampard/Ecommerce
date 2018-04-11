package com.sqli.challenge.presenters;

import com.sqli.challenge.entities.Cart;

public interface Presenter {
    String cartContentPresenter (Cart products);
    String summaryPresenter (Cart products);
}
