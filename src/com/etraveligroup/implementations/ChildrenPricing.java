package com.etraveligroup.implementation;

import com.etraveligroup.interfaces.PricingStrategy;

public class ChildrenPricing implements PricingStrategy {
    /**
     * @param days
     * @return
     */
    @Override
    public double calculateCost(int days) {
        double cost = 1.5;
        if (days > 3) {
            cost += (days - 3) * 1.5;
        }
        return cost;
    }
}
