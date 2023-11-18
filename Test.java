import java.util.ArrayList;
import  java.util.Date;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        ArrayList<Flight> FlightList= new ArrayList<>();
        ArrayList<Passenger> passengersList= new ArrayList<>();
        ArrayList<Ticket> TicketList= new ArrayList<>();
        ArrayList<Reservation> ReservationList=  new ArrayList<>();
        ArrayList<Feedback> FeedbackList= new ArrayList<>();
        ArrayList<Airport> ArrivalAirportList = Airport.getArrivalAirports();
        ArrayList<Airport> DepartueAirportList = Airport.getDepartureAirports();
       
        Date d1 = new Date();
    
    int flightNumberCounter = 100; 
    double[] flightDuration = {1.5,2.6,3.8,9.8,15.6,17.9,20.2,5.7,5.9,8.34};
    for (int i = 0; i < ArrivalAirportList.size(); i++) {
        for (int j = 0; j < DepartueAirportList.size(); j++) {
            double duration= flightDuration[flightNumberCounter%flightDuration.length];
            flightNumberCounter++;
            String flightNumber = "LH" + flightNumberCounter; 
            FlightList.add(new Flight(flightNumber, d1, d1, duration, ArrivalAirportList.get(i).getAirportName(), DepartueAirportList.get(j).getAirportName())); 
     } }
    Scanner  input = new Scanner(System.in);
    Scanner  input1 = new Scanner(System.in);
    System.out.println("------------Airline management System------------");
    while (true) {
        System.out.println("Enter 1 to Display Flight Schedule");
        System.out.println("Enter 2 to Book Flight ");
        System.out.println("Enter 3 to Give Feedback ");
        System.out.println("Enter 0 to terminate the program");
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (input.hasNextInt()) {
                choice = input.nextInt();
                break; // Break the inner loop if an integer is entered
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next(); // Consume the invalid input
            }
        }
        if(choice==0){
            System.out.println("-----------------------------------------");
            System.out.println("the program has been terminated");
            System.out.println("-----------------------------------------");
            break;
        }
        else{
            if (choice==1) {
                Flight.displayFlightSchedule(FlightList);
                } 
               else if (choice == 2) {
                    System.out.println("-----------------Booking Menu-----------------");
                    System.out.println("-------------Personal Information--------------");
                    System.out.println("Enter your name :");
                    String passName = input1.nextLine();
                    System.out.println("Enter your age : ");
                    int age;
                    while (true) {
                        if (input.hasNextInt()) {
                            age = input.nextInt();
                            if (age >= 18 && age <= 100) {
                                break; // Break the loop if a valid integer within the range is entered
                            } else {
                                System.out.println("Invalid age. Please enter an age between 18 and 100.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            input.next(); // Consume the invalid input
                        }
                    }
                    input.nextLine();
                    System.out.println("Enter your Email :");
                    String email = input.nextLine();
                    System.out.println("Enter your PhoneNumber :");
                    long number;
                    while (true) {
                        if (input.hasNextLong()) {
                            number = input.nextLong();
                            break; // Break the loop if a valid long is entered
                        } else {
                            System.out.println("Invalid phone number. Please enter a valid number.");
                            input.next(); // Consume the invalid input
                        }
                    }
                    input.nextLine();
                    System.out.println("Enter Ticket Class  :");
                    String ticketClass;
                    while (true) {
                        ticketClass = input.nextLine().toLowerCase(); // Convert to lowercase for case-insensitivity
                        if (ticketClass.equals("economy") || ticketClass.equals("business") || ticketClass.equals("first class")) {
                            break; // Break the loop if a valid ticket class is entered
                        } else {
                            System.out.println("Invalid ticket class. Please enter 'economy,' 'business,' or 'first class'.");
                        }
                    }
                    passengersList.add(new Passenger(passName, email, number, age, ticketClass));
                    System.out.println("-----------Flight Information-----------");
                    System.out.println("Enter Departure Airport:");

                    String depAirport;
                    boolean foundDeparture;
                    do {
                        depAirport = input.nextLine().trim(); // Trim whitespace

                        foundDeparture = false;
                        if (depAirport.isEmpty()) {
                            System.out.println("Please enter a valid departure airport.");
                        } else {
                            //back end
                            System.out.println("-----Scheduled Flights------");
                            int index = 0;
                            for (Flight fl : FlightList) {
                                index++;
                                if (fl.getDepartueAirport().equalsIgnoreCase(depAirport)) {
                                    foundDeparture = true;
                                    System.out.println("Flight  :" + (index) );
                                    System.out.println("Flight Number  " + " : " + fl.getFlightNumber());
                                    System.out.println("Arrival Time   " + " : " + fl.getArrivalTime());
                                    System.out.println("Departure Time " + "  : " + fl.getDepartureTime());
                                    System.out.println("Arrival Airport" + "   : " + fl.getDestinationAirport());
                                    System.out.println("--------------------------------------------------------");
                                }
                            }
                                if (!foundDeparture) {
                                    System.out.println("No scheduled flights found departing from " + depAirport);
                                    System.out.println("Please enter a valid departure airport.");
                                }
                        }
                    } while (!foundDeparture);
                    System.out.println("------------Select Flight---------- ");
                    System.out.println("Enter the Flight Number from available list :");
                    String flightNo;
                    boolean foundFlightNo;
                    do {
                        flightNo = input.nextLine();
                        foundFlightNo = false;
                        for (Flight f1 : FlightList) {
                            if (f1.getFlightNumber().equalsIgnoreCase(flightNo)) {
                                foundFlightNo = true;
                                break;
                            }
                        }
                        if (!foundFlightNo) {
                            System.out.println("Flight number not found! Please enter a valid flight number.");
                        }
                    } while (!foundFlightNo);
                    if (!flightNo.isEmpty()) {
                           foundFlightNo=false;
                          for(Flight f1: FlightList){
                              if (f1.getFlightNumber().equalsIgnoreCase(flightNo)) {
                                      foundFlightNo=true;
                                       System.out.println( "Flight Duration :" +f1.getFlightDuration());
                          }
                             }
                             if (!foundFlightNo) {
                                System.out.println("Flight Number not found!!!!");
                             break;
                             }
                    }
                    System.out.println("--------Press enter 'yes' to Book and 'no' to terminate---------");
                    String enter;
                    do {
                        enter = input.nextLine().toLowerCase();
                        if (enter.equals("yes") || enter.equals("no")) {
                            break; 
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'."); }
                    } while (true);
                    if (enter.equals("yes")) {
                    } else {
                        System.out.println("--------------Program Terminated-------------"); }
                    if (enter.equalsIgnoreCase("yes")) {
                                Ticket.handleTicketClass(passName, email, number, age, ticketClass);
                             }else if (enter.equalsIgnoreCase("no")) {
                                    System.out.println("--------------Program Terminated-------------");
                                    break;  }
    System.out.println("--------Reservation Successful---------");
    ReservationList.add(new Reservation("LH00000092", FlightList, passengersList, TicketList));
    System.out.println("Enter 'yes' to Print the ticket and 'no' to Exit");
    String option;
                do {
                    option = input.nextLine().toLowerCase();
                    if (option.equals("yes") || option.equals("no")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }}
                     while (true);
                if (option.equalsIgnoreCase("yes")) {
                    Reservation.printDetailsByFlightNumber(ReservationList, flightNo);
                }
                else if (option.equalsIgnoreCase("no")) {
                    System.out.println("--------------Program Terminated-------------");
                     break;
                    } }
                else if (choice == 3) {
                input.nextLine();
                System.out.println("Please enter your name: ");
                String name = input.nextLine();
                System.out.println("Please enter Feedback Content: ");
                String content = input.nextLine();
                int rate;
                while (true) {
                    System.out.print("Please rate our service (1-10): ");
                    if (input.hasNextInt()) {
                        rate = input.nextInt();
                        if (rate >= 1 && rate <= 10) {
                            break; 
                        } else {
                            System.out.println("Invalid rating. Please enter a number between 1 and 10.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        input.next();
                    } }
        input.nextLine(); 
        FeedbackList.add(new Feedback(name, content, rate, d1));
        System.out.println("Thank you for your feedback!");
        System.out.println("-------------Our Reviews-------------");
        Feedback.printFeedback(FeedbackList);
}}}}}

    
