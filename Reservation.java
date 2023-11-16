import java.util.ArrayList;
public class Reservation {
    private String reservationNumber;
    ArrayList<Flight> flightList;
    ArrayList<Passenger> passengersList;
    ArrayList<Ticket>  TicketList;
    public Reservation(String reservationNumber, ArrayList<Flight> flightList, ArrayList<Passenger> passengersList,
            ArrayList<Ticket> ticketList) {
        this.reservationNumber = reservationNumber;
        this.flightList = flightList;
        this.passengersList = passengersList;
        TicketList = ticketList;
    }
    public String getReservationNumber() {
        return reservationNumber;
    }
    public ArrayList<Flight> getFlightList() {
        return flightList;
    }
    public ArrayList<Passenger> getPassengersList() {
        return passengersList;
    }
    public ArrayList<Ticket> getTicketList() {
        return TicketList;
    }
   
    
}
