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

}
