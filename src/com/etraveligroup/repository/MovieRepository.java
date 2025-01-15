package com.etraveligroup.repository;

import com.etraveligroup.entity.Movie;
import com.etraveligroup.implementation.ChildrenPricing;
import com.etraveligroup.implementation.NewReleasePricing;
import com.etraveligroup.implementation.RegularPricing;

import java.util.HashMap;

public class MovieRepository {
    private HashMap<String, Movie> movies;

    public MovieRepository() {
        movies = new HashMap<>();
        movies.put("F001", new Movie("You've Got Mail", new RegularPricing()));
        movies.put("F002", new Movie("Matrix", new RegularPricing()));
        movies.put("F003", new Movie("Cars", new ChildrenPricing()));
        movies.put("F004", new Movie("Fast & Furious X", new NewReleasePricing()));
    }

    public Movie getMovie(String id) {
        return movies.get(id);
    }
}
