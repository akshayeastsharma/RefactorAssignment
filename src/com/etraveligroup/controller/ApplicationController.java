package com.etraveligroup.controller;

import com.etraveligroup.entity.Customer;
import com.etraveligroup.entity.MovieRental;
import com.etraveligroup.repository.MovieRepository;
import com.etraveligroup.service.FrequentPointsService;
import com.etraveligroup.service.RentalStatementService;
import com.etraveligroup.serviceImpl.FrequentPointServiceImpl;
import com.etraveligroup.serviceImpl.RentalStatementServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ApplicationController {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    try {
      // Ask for customer's name
      System.out.print("Enter customer's name: ");
      String customerName = scanner.nextLine();

      // Initialize the MovieRepository
      MovieRepository movieRepo = new MovieRepository();

      // Create a list to hold movie rentals
      List<MovieRental> rentals = new ArrayList<>();

      // Ask for movie rentals
      while (true) {
        System.out.print("Enter movie ID (or 'done' to finish): ");
        String movieId = scanner.nextLine();

        if (movieId.equalsIgnoreCase("done")) {
          break;
        }

        // Check if the movie ID exists in the repository
        if (movieRepo.getMovie(movieId) == null) {
          System.out.println("Invalid movie ID. Try again.");
          continue;
        }

        // Ask for rental duration (in days)
        System.out.print("Enter number of days for rental: ");
        int days = Integer.parseInt(scanner.nextLine());

        // Add the rental to the list
        rentals.add(new MovieRental(movieRepo.getMovie(movieId), days));
      }

      // Create the FrequentPointsService and RentalStatementService with dependency injection
      FrequentPointsService pointsService = new FrequentPointServiceImpl();
      RentalStatementService statementService = new RentalStatementServiceImpl(pointsService);

      // Create the customer with the provided rentals
      Customer customer = new Customer(customerName, rentals);

      // Generate rental statement
      String result = statementService.generateStatement(customer);

      // Output the rental statement
      System.out.println(result);

    } catch (Exception e) {
      System.err.println("An error occurred: " + e.getMessage());
    } finally {
      scanner.close();
    }
  }
}
