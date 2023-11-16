import java.util.ArrayList;
import  java.util.Date;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
    ArrayList<Airport> ArrivalAirportList= new ArrayList<>();
    ArrayList<Airport> DepartueAirportList= new ArrayList<>();
    ArrayList<Flight> FlightList= new ArrayList<>();
    ArrayList<Passenger> passengersList= new ArrayList<>();
    ArrayList<Ticket> TicketList= new ArrayList<>();
    

    ////////////////////////////////////////////////////////
    Airport a1 = new Airport("Allama Iqbal Airport", "1092", "Lahore", "Pakistan");
    Airport a3 = new Airport("Jinnah International", "1091", "Karachi", "Pakistan");
    Airport a4 = new Airport("Multan International", "1094", "Multan", "Pakistan");
    Airport a5 = new Airport("Faisalabad International", "1082", "Faisalabad", "Pakistan");
    Airport a2 =new Airport("Benezir Intl Airport", "1091", "Larkana", "Pakistan");
    Airport a6 =new Airport("Heathrow Intl Airport", "1091", "London", "Pakistan");
    Airport a7 =new Airport("JFK Airport", "1086", "New York", "USA");
    Airport a8 =new Airport("Doha Airport ", "1088", "Doha", "Pakistan");
    Airport a9 =new Airport("Dubai Int Airport", "1066", "Dubai ", "Dubai");
    ///////////////////////////////////////////////////////

    ArrivalAirportList.add(a1);
    ArrivalAirportList.add(a2);
    ArrivalAirportList.add(a3);
    ArrivalAirportList.add(a4);
    DepartueAirportList.add(a5);
    DepartueAirportList.add(a6);
    DepartueAirportList.add(a7);
    DepartueAirportList.add(a8);
    DepartueAirportList.add(a9);
    Date d1 = new Date();

    ///gotta iterate through dep and arr airport list to schedule different flights and gotta add each flights duration and calculate the fare accordingly
    int flightNumberCounter = 100; // Starting flight number
    double[] flightDuration = {1.5,2.6,3.8,9.8,15.6,17.9,20.2,5.7,5.9,8.34};
    for (int i = 0; i < ArrivalAirportList.size(); i++) {
        for (int j = 0; j < DepartueAirportList.size(); j++) {
            double duration= flightDuration[flightNumberCounter%flightDuration.length];
            flightNumberCounter++;
            String flightNumber = "LH" + flightNumberCounter; 
            FlightList.add(new Flight(flightNumber, d1, d1, duration, ArrivalAirportList.get(i).getAirportName(), DepartueAirportList.get(j).getAirportName()));
                
        }
    }
    
     
    ArrayList<Reservation> ReservationList=  new ArrayList<>();
    TicketList.add(new Ticket("Lh922", "L10822", passengersList, FlightList));
    ReservationList.add(new Reservation("Lh922", FlightList, passengersList, TicketList));
    ArrayList<Feedback> FeedbackList= new ArrayList<>();
    FeedbackList.add(new Feedback("Danial", "Satisfied", 10, d1))    ;

    Scanner  input = new Scanner(System.in);
    Scanner  input1 = new Scanner(System.in);

    System.out.println("------------Airline management System------------");
    while (true) {
        System.out.println("Enter 1 to Display Flight Schedule");
        System.out.println("Enter 2 to Book Flight ");
        System.out.println("Enter 3 to Give Feedback ");
        System.out.println("Enter 0 to terminate the program");
        int choice= input.nextInt();
        if(choice==0){
            System.out.println("-----------------------------------------");
            System.out.println("the program has been terminated");
            System.out.println("-----------------------------------------");
            break;
        }
        else{
            if (choice==1) {
                System.out.println("----Flight Schedule----");
                for (int i = 0; i < FlightList.size(); i++) {
                    System.out.println("flight no              :" + FlightList.get(i).getFlightNumber());
                    System.out.println("Destination Airport    :"+ FlightList.get(i).getDestinationAirport());
                    System.out.println("Departue Airport       :"+FlightList.get(i).getDepartueAirport());
                    System.out.println("Arrival Time           :" + FlightList.get(i).getArrivalTime());
                    System.out.println("Departure Time         :" + FlightList.get(i).getDepartureTime());
                    System.out.println("----------------------------------------------------------------");
                    }
                }
                   
               else if (choice == 2) {
                    System.out.println("-----------------Booking Menu-----------------");
                    System.out.println("-------------Personal Information--------------");
                    System.out.println("Enter your name :");
                    String passName = input1.nextLine();
                    System.out.println("Enter your age : ");
                    int age = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter your Email :");
                    String email = input.nextLine();
                    input.nextLine(); 
                    System.out.println("Enter your PhoneNumber :");
                    long number = input.nextLong();
                    input.nextLine(); 
                    System.out.println("Enter Ticket Class  :");
                    String ticketClass = input.nextLine(); 
                    passengersList.add(new Passenger(passName, email, number, age, ticketClass));
                    System.out.println("-----------Flight Information-----------");
                    System.out.println("Enter Departure Airport :");
                    
                   String depAirport = input.nextLine();
                   if (!depAirport.isEmpty()) {
                       boolean foundDeparture = false;
                       System.out.println("-----Scheduled Flights------");
                       int index=0;
                       for (Flight fl : FlightList) {
                        index++;
                            if (fl.getDepartueAirport().equalsIgnoreCase(depAirport)) {
                                foundDeparture = true;
                                System.out.println("Flight Number  " + (index) +" : "  + fl.getFlightNumber());
                                System.out.println("Arrival Time   " + (index)+ " : "+fl.getArrivalTime());
                                System.out.println("Departure Time " +(index)+ "  : "+ fl.getDepartureTime());
                                System.out.println("Arrival Airport" +(index)+"   : "+ fl.getDestinationAirport());
                                System.out.println("--------------------------------------------------------");
            }
        }
        
                                if (!foundDeparture) {
                                    System.out.println("No flights found departing from " + depAirport);
                                break;
        }
    }
                  System.out.println("------------Select Flight---------- ");
                  System.out.println("Enter the Flight Number :");
                  String flightNo= input.nextLine();
                  if (!flightNo.isEmpty()) {
                      boolean foundFlightNo=false;
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
                         System.out.println("--------Press enter yes to Book and no to terminate---------");
                         String enter= input.nextLine();
                         
                         if (enter.equalsIgnoreCase("yes")) {
                             if (ticketClass.equalsIgnoreCase("economy")) {
                                 TicketList.add(new Ticket("LH1222777","Lh1092777" , passengersList, FlightList)) ;
                                 Economic e1 = new Economic(passName, email, number, age, ticketClass, number);
                                 System.out.println("Total Fare  : "  + e1.CalculateFare() );
            
        }
        else if (ticketClass.equalsIgnoreCase("Business")) {
            Business b1 = new Business(passName, email, number, age, ticketClass, number);
            TicketList.add(new Ticket("LH1222777","Lh1092777" , passengersList, FlightList)) ;
            System.out.println("Total Fare : " + b1.CalculateFare());
        }
        else if (ticketClass.equalsIgnoreCase("FirstClass")) {
            FirstClass first = new FirstClass(passName, email, number, age, ticketClass, number);
            TicketList.add(new Ticket("LH1222777","Lh1092777" , passengersList, FlightList)) ;
            System.out.println("Total Fare :" + first.CalculateFare() );
            
        }
        }else if (enter.equalsIgnoreCase("no")) {
        System.out.println("--------------Program Terminated-------------");
        break;
        
    }
    System.out.println("--------Reservation Successful---------");
    ReservationList.add(new Reservation("LH00000092", FlightList, passengersList, TicketList));
    System.out.println("Enter yes to Print the ticket and no to Exit");
    String option = input.nextLine();
    if (option.equalsIgnoreCase("yes")) {
        System.out.println("--------------Ticket--------------");
       for (Reservation res : ReservationList) {
        for(Passenger passenger: res.passengersList){
            for (Flight flight : res.flightList) {
                if (flightNo.equalsIgnoreCase(flight.getFlightNumber())) {
                    System.out.println("flightNo :"+ flight.getFlightNumber());
                    System.out.println("flight Duration : " +  flight.getFlightDuration());
                    System.out.println("Departure Airport : " +  flight.getDepartueAirport());
                    System.out.println("Destination Airport : " +  flight.getDestinationAirport());                    
                }
                
            }
            System.out.println("Passenger name  :" + passenger.getName());
            System.out.println("Age  :" +  passenger.getAge());
            System.out.println("Contact number :" +  passenger.getPhoneNumber());
            System.out.println("ticket Class : " + passenger.getTicketClass() );
            System.out.println("-------------------------------------------------------------------------------");
        
        }
        
       }
    } else if (option.equalsIgnoreCase("no")) {
        break;
    }
}
else if (choice == 3) {
    System.out.println("---------Feedback-----------");
    input.nextLine(); 
    System.out.println("Please enter your name: ");
    String name = input.nextLine();
    System.out.println("Please enter Feedback Content: ");
    String content = input.nextLine();
    System.out.println("Please rate our service (1-10): ");
    int rate = input.nextInt();
    input.nextLine(); 

    Feedback f1 = new Feedback(name, content, rate, d1);
    FeedbackList.add(f1);

    System.out.println("Thank you for your feedback!");
    System.out.println("-------------Our Reviews-------------");
    int index=0;
    for (Feedback f : FeedbackList) {
        index++;
        System.out.println("Feedback content  " + (index) +":" + f.getFeedBackContent());
        System.out.println("Rating            " + (index) +":"+f.getRating());
        System.out.println("---------------------------------------------------------");
    }
}

        
}
    }
}
}

    
