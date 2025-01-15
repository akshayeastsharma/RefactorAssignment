package com.etraveligroup.serviceImpl;

import com.etraveligroup.entity.Customer;
import com.etraveligroup.entity.MovieRental;
import com.etraveligroup.implementation.NewReleasePricing;
import com.etraveligroup.service.FrequentPointsService;
import com.etraveligroup.service.RentalStatementService;

public class RentalStatementServiceImpl implements RentalStatementService {

    private final FrequentPointsService pointsService;

    // Constructor-based Dependency Injection
    public RentalStatementServiceImpl(FrequentPointsService pointsService) {
        this.pointsService = pointsService;
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public String generateStatement(Customer customer) {
        double totalAmount = 0;
        int frequentPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

        for (MovieRental rental : customer.getRentals()) {
            double cost = rental.calculateCost();
            frequentPoints += pointsService.calculateFrequentPoints(rental); // Using FrequentPointsService

            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(cost).append("\n");
            totalAmount += cost;
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentPoints).append(" frequent points\n");

        return result.toString();

    }
}
