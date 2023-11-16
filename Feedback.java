import java.util.Date;
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
    


    
}
