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


    public void printTicket() {
        System.out.println("name : "+ passengerInfo.getName());
        System.out.println("age : "+ passengerInfo.getAge());
        System.out.println("Phone : "+ passengerInfo.getPhoneNumber());
        System.out.println("reservation Number  : "+  reservationNumber);
        System.out.println("flight info1 :" + flightInfo.getFlightNumber());
        // for (int i = 0; i < flightInfo.getAirportList().size(); i++) {
        //     System.out.println("flight info2 :" + f.getAirportList().get(i));
            
        // }
        System.out.println(flightInfo.getDepartureTime());

        System.out.println("ticket Number :" + ticketNumber);
        
    }
}
