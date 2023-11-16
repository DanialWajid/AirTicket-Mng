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

}
