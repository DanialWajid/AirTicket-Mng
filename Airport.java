import java.util.ArrayList;

public class Airport {
    private String  airportName;
    private String  code;
    private String  city;
    private String  country;

    public Airport(String airportName, String code, String city, String country) {
        this.airportName = airportName;
        this.code = code;
        this.city = city;
        this.country = country;
       
    }
    public String getAirportName() {
        return airportName;
    }
    public String getCode() {
        return code;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    public static ArrayList<Airport> getArrivalAirports() {
        ArrayList<Airport> arrivalAirports = new ArrayList<>();
        arrivalAirports.add(new Airport("Allama Iqbal Airport", "1092", "Lahore", "Pakistan"));
        arrivalAirports.add(new Airport("Jinnah International", "1091", "Karachi", "Pakistan"));
        arrivalAirports.add(new Airport("Multan International", "1094", "Multan", "Pakistan"));
        arrivalAirports.add(new Airport("Faisalabad International", "1082", "Faisalabad", "Pakistan"));
        return arrivalAirports;
    }
    public static ArrayList<Airport> getDepartureAirports() {
        ArrayList<Airport> departureAirports = new ArrayList<>();
        departureAirports.add(new Airport("Benezir Intl Airport", "1091", "Larkana", "Pakistan"));
        departureAirports.add(new Airport("Heathrow Intl Airport", "1091", "London", "United Kingdom"));
        departureAirports.add(new Airport("JFK Airport", "1086", "New York", "USA"));
        departureAirports.add(new Airport("Doha Airport", "1088", "Doha", "Qatar"));
        departureAirports.add(new Airport("Dubai Int Airport", "1066", "Dubai", "UAE"));
        return departureAirports;
    }
    

}
