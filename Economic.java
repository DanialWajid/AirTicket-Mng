
    public class Economic extends Passenger implements Fare {
        private double flightDuration;
    
          
          public Economic(String name, String email, long phoneNumber, int age, String ticketClass,
                double flightDuration) {
            super(name, email, phoneNumber, age, ticketClass);
            this.flightDuration = flightDuration;
        }

    
    
        @Override
        public  double CalculateFare() {
            return (baseFare*flightDuration) + tax - discount;
        }



        public double getFlightDuration() {
            return flightDuration;
        }
    }
    

