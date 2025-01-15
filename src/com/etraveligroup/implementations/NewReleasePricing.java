package com.etraveligroup.implementation;

import com.etraveligroup.interfaces.PricingStrategy;

public class NewReleasePricing implements PricingStrategy {

    /**
     * @param days
     * @return
     */
    @Override
    public double calculateCost(int days) {
        return days * 3;
    }
}
