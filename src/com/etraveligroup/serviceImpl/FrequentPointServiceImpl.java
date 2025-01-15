package com.etraveligroup.serviceImpl;

import com.etraveligroup.entity.MovieRental;
import com.etraveligroup.implementation.NewReleasePricing;
import com.etraveligroup.service.FrequentPointsService;

public class FrequentPointServiceImpl implements FrequentPointsService {

    @Override
    public int calculateFrequentPoints(MovieRental rental) {
        int points = 1;  // Earn 1 frequent point for every rental

        // Add bonus points for new releases rented for more than 2 days
        if (rental.getMovie().getPricingStrategy() instanceof NewReleasePricing && rental.getDays() > 2) {
            points++;
        }

        return points;
    }
}