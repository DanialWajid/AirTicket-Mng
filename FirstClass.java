public class FirstClass extends Passenger implements Fare {
     private final double superTax=20000;
    private double FlightDuration;
    
    public FirstClass(String name, String email, long phoneNumber, int age, String ticketClass, double flightDuration) {
        super(name, email, phoneNumber, age, ticketClass);
        FlightDuration = flightDuration;
    }

    public double getSuperTax() {
        return superTax;
    }
    
    public double getFlightDuration() {
        return FlightDuration;
    }

    @Override
    public double CalculateFare() {
        return (baseFare*FlightDuration) + tax - discount + superTax;
    }
    
}