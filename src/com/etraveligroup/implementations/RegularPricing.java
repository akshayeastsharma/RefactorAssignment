package com.etraveligroup.implementation;

import com.etraveligroup.interfaces.PricingStrategy;

public class RegularPricing implements PricingStrategy {
    /**
     * @param days
     * @return
     */
    @Override
    public double calculateCost(int days) {
        double cost = 2;
        if (days > 2) {
            cost += (days - 2) * 1.5;
        }
        return cost;

    }
}
