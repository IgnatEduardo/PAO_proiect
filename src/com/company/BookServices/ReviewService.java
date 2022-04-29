package com.company.BookServices;

import com.company.BookClasses.Book;
import com.company.BookClasses.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewService {
    private final List<Review> reviews = new ArrayList<>();
    private static ReviewService instance;

    private ReviewService(){}

    public static ReviewService getInstance() {
        if(instance == null){
            instance = new ReviewService();
        }
        return instance;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }
}
