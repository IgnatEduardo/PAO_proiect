package com.company.book.service;

import com.company.book.entity.Book;
import com.company.book.entity.Review;
import com.company.csv.CsvReaderService;
import com.company.csv.CsvWriterService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ReviewService {
    private final List<Review> reviews = new ArrayList<>();
    private static ReviewService instance;

    private ReviewService(){}

    CsvReaderService csvReaderService = CsvReaderService.getInstance();
    CsvWriterService csvWriterService = CsvWriterService.getInstance();

    public static ReviewService getInstance() {
        if(instance == null){
            instance = new ReviewService();
        }
        return instance;
    }

    public void readReviewInCsv() throws ParseException {
        List<String[]> reviewList = csvReaderService.readReviewsFromCsv();
        for (String[] strings : reviewList) {
            Review newReview = createReview(strings[0], strings[1]);
            reviews.add(newReview);
        }
    }

    public Review createReview(String subject, String context) throws ParseException {
        return new Review(subject, context);
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }
}
