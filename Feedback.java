import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class Feedback {
    private String passengerName;
    private String feedBackContent;
    private int rating;
    private Date SubmissionDate;
    public Feedback(String passengerName, String feedBackContent, int rating, Date submissionDate) {
        this.passengerName = passengerName;
        this.feedBackContent = feedBackContent;
        this.rating = rating;
        SubmissionDate = submissionDate;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public String getFeedBackContent() {
        return feedBackContent;
    }
    public int getRating() {
        return rating;
    }
    public Date getSubmissionDate() {
        return SubmissionDate;
    } 
    


    public static void printFeedback(List<Feedback> feedbackList) {
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
