package com.example.myfx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class Feedback {
    private String passengerName;
    private String feedBackContent;
    private int rating;
    private String SubmissionDate;
    public Feedback(String passengerName, String feedBackContent, int rating, String submissionDate) {
        this.passengerName = passengerName;
        this.feedBackContent = feedBackContent;
        if (rating >10 | rating <1){
            throw  new invalidRatingException();
        }
        this.rating = rating;
        SubmissionDate = submissionDate;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public String getFeedbackContent() {
        return feedBackContent;
    }
    public int getRating() {
        return rating;
    }
    public String getSubmissionDate() {
        return SubmissionDate;
    } 
    

    public static void printFeedback(List<Feedback> feedbackList) {             // Static method to print a list of feedback
        int index = 0;
        for (Feedback f : feedbackList) {
            index++;
            System.out.println("Review " + index + ":");
            System.out.println("User Name: " + f.passengerName);
            System.out.println("Feedback content: " + f.feedBackContent);
            System.out.println("Rating: " + f.rating);
            System.out.println("Submission Date: " + f.SubmissionDate);
            System.out.println("---------------------------------------------------------");
        }
    }
    


    
}
