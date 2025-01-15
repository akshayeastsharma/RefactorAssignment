package com.etraveligroup.controller;

import com.etraveligroup.entity.Customer;
import com.etraveligroup.entity.MovieRental;
import com.etraveligroup.repository.MovieRepository;
import com.etraveligroup.service.FrequentPointsService;
import com.etraveligroup.service.RentalStatementService;
import com.etraveligroup.serviceImpl.FrequentPointServiceImpl;
import com.etraveligroup.serviceImpl.RentalStatementServiceImpl;

import java.util.Arrays;

public class ApplicationController {
  public static void main(String[] args) {
    try {
      String expected = "Rental Record for Customer1\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";
      MovieRepository movieRepo = new MovieRepository();

      // Create customer with rentals
      Customer customer = new Customer("Customer1", Arrays.asList(
              new MovieRental(movieRepo.getMovie("F001"), 3),
              new MovieRental(movieRepo.getMovie("F002"), 1)
      ));

      // Create the FrequentPointsService and RentalStatementService with dependency injection
      FrequentPointsService pointsService = new FrequentPointServiceImpl();
      RentalStatementService statementService = new RentalStatementServiceImpl(pointsService);

      // Generate rental statement
      String result = statementService.generateStatement(customer);

      // Output the result and compare with expected
      System.out.println(result);
      if (!result.equals(expected)) {
        throw new AssertionError("Expected: " + System.lineSeparator() + expected + System.lineSeparator() +
                "Got: " + System.lineSeparator() + result);
      }
    } catch (AssertionError e) {
      System.err.println("Assertion failed: " + e.getMessage());
      e.printStackTrace();
    } catch (Exception e) {
      System.err.println("An unexpected error occurred: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
