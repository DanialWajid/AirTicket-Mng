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
    public static void printDetailsByFlightNumber(ArrayList<Reservation> reservationList, String flightNo) {
        System.out.println("--------------Ticket--------------");
        for (Reservation res : reservationList) {
            for (Passenger passenger : res.getPassengersList()) {
                for (Flight flight : res.getFlightList()) {
                    if (flightNo.equalsIgnoreCase(flight.getFlightNumber())) {
                        System.out.println("Flight Number: " + flight.getFlightNumber());
                        System.out.println("Flight Duration: " + flight.getFlightDuration());
                        System.out.println("Departure Airport: " + flight.getDepartueAirport());
                        System.out.println("Destination Airport: " + flight.getDestinationAirport());

                        for (Ticket ticket : res.getTicketList()) {
                            System.out.println("Ticket Number: " + ticket.getTicketNumber());
                            System.out.println("Reservation Number: " + ticket.getReservationNumber());
                            System.out.println("-----------------------------------------------");
                        }

                        System.out.println("Passenger name: " + passenger.getName());
                        System.out.println("Age: " + passenger.getAge());
                        System.out.println("Contact number: " + passenger.getPhoneNumber());
                        System.out.println("Ticket Class: " + passenger.getTicketClass());
                        System.out.println("-------------------------------------------------------------------------------");
                    }
                }
            }
        }
    }
    

    
}
