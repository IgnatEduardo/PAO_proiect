package com.company.book.entity;

import com.company.user.entity.Customer;

public class Review {
    private Customer reviewer;
    private Book bookReviewed;
    private String subject, review;

    public Review(){}

    public Review(String subject, String review){
        this.subject = subject;
        this.review = review;
    }

    public Review(Customer reviewer, Book bookReviewed, String subject, String review) {
        this.reviewer = reviewer;
        this.bookReviewed = bookReviewed;
        this.subject = subject;
        this.review = review;
    }

    public Customer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Customer reviewer) {
        this.reviewer = reviewer;
    }

    public Book getBookReviewed() {
        return bookReviewed;
    }

    public void setBookReviewed(Book bookReviewed) {
        this.bookReviewed = bookReviewed;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return  "Reviewer: " + this.reviewer.getName() +
                "Book reviewed: " + this.bookReviewed.getName() +
                "Subject: " + this.subject +
                "Review: " + this.review
                ;
    }
}
