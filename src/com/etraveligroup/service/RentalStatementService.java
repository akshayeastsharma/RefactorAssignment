package com.etraveligroup.service;

import com.etraveligroup.entity.Customer;

public interface RentalStatementService {

    String generateStatement(Customer customer);
}
