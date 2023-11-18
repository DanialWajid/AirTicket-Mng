import java.util.ArrayList;

public class Ticket {
    private String reservationNumber;
    private String ticketNumber;
    ArrayList<Passenger> passengersList;
    ArrayList<Flight> FlightList;
  
    public Ticket(String reservationNumber, String ticketNumber, ArrayList<Passenger> passengersList,
            ArrayList<Flight> flightList) {
        this.reservationNumber = reservationNumber;
        this.ticketNumber = ticketNumber;
        this.passengersList = passengersList;
        FlightList = flightList;
    }
    

    public String getReservationNumber() {
        return reservationNumber;
    }


    public String getTicketNumber() {
        return ticketNumber;
    }


    public ArrayList<Passenger> getPassengersList() {
        return passengersList;
    }


    public ArrayList<Flight> getFlightList() {
        return FlightList;
    }
    public  static void handleTicketClass(String passName, String email, Long number, int age, String ticketClass) {
        double fare=0.0;

        if (ticketClass.equalsIgnoreCase("Economy")) {
          Economic e1 = new Economic(passName, email, number, age, ticketClass, number);
          fare = e1.CalculateFare();
      
      
       
        } else if (ticketClass.equalsIgnoreCase("Business")) {
          Business b1 = new Business(passName, email, number, age, ticketClass, number);
          fare = b1.CalculateFare();
        
      
        
        } else if (ticketClass.equalsIgnoreCase("FirstClass")) {
          FirstClass first = new FirstClass(passName, email, number, age, ticketClass, number);
          fare = first.CalculateFare();
        }
        System.out.println("the Fare fot the Ticket  Class    " + ticketClass + " class is : $" + fare);
    }


}
