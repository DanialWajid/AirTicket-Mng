import java.util.Date;
import java.util.ArrayList;
public class Flight {
    private String flightNumber;
    private Date departureTime;
    private Date arrivalTime;
    private ArrayList < Airport> ArrivalAirportList;
    private ArrayList < Airport> DepartueAirportList;
    public Flight(String flightNumber, Date departureTime, Date arrivalTime, ArrayList<Airport> arrivalAirportList,
            ArrayList<Airport> departueAirportList) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        ArrivalAirportList = arrivalAirportList;
        DepartueAirportList = departueAirportList;
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
    public ArrayList<Airport> getArrivalAirportList() {
        return ArrivalAirportList;
    }
    public ArrayList<Airport> getDepartueAirportList() {
        return DepartueAirportList;
    }

   


}
