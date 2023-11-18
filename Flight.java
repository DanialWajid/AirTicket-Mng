import java.util.Date;
import java.util.ArrayList;
public class Flight {
    private String flightNumber;
    private Date departureTime;
    private Date arrivalTime;
    private double flightDuration;
    private String departueAirport;
    private String destinationAirport;
    public Flight(String flightNumber, Date departureTime, Date arrivalTime, double flightDuration,
            String departueAirport, String destinationAirport) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightDuration = flightDuration;
        this.departueAirport = departueAirport;
        this.destinationAirport = destinationAirport;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public Date getDepartureTime() {
        return departureTime;
    }
    public Date getArrivalTime() {
        return arrivalTime;
    }
    public double getFlightDuration() {
        return flightDuration;
    }
    public String getDepartueAirport() {
        return departueAirport;
    }
    public String getDestinationAirport() {
        return destinationAirport;
    }
    public static void displayFlightSchedule(ArrayList<Flight> FlightList) {
        if (FlightList.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }

        System.out.println("----Flight Schedule----");
        for (Flight flight : FlightList) {
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Destination Airport: " + flight.getDestinationAirport());
            System.out.println("Departure Airport: " + flight.getDepartueAirport());
            System.out.println("Arrival Time: " + flight.getArrivalTime());
            System.out.println("Departure Time: " + flight.getDepartureTime());
            System.out.println("-----------------------------------------------");
        }
    }
}

