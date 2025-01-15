package com.etraveligroup.entity;

import com.etraveligroup.interfaces.PricingStrategy;

public class Movie {
    private String title;
    private PricingStrategy pricingStrategy;

    public Movie(String title, PricingStrategy pricingStrategy) {
        this.title = title;
        this.pricingStrategy = pricingStrategy;
    }

    public String getTitle() {
        return title;
    }

    public double calculateCost(int days) {
        return pricingStrategy.calculateCost(days);
    }

    public PricingStrategy getPricingStrategy() {
        return this.pricingStrategy;
    }
}
