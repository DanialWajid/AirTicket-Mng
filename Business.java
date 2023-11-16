public class Business extends Passenger implements Fare {
     private final double  superTax=12000;
    private double FlightDuration;
    
    public Business(String name, String email, long phoneNumber, int age, String ticketClass, double flightDuration) {
        super(name, email, phoneNumber, age, ticketClass);
        FlightDuration = flightDuration;
    }
    
    public double getFlightDuration() {
        return FlightDuration;
    }

    @Override
    public double CalculateFare() {
        
        return (baseFare*FlightDuration)+ tax + superTax - discount;
    }


    
}
