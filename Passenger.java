public class Passenger {
private String  name;
private String  email;
private long  PhoneNumber;
private int  age;
private String ticketClass;
    public Passenger(String name, String email, long phoneNumber, int age, String ticketClass) {
    this.name = name;
    this.email = email;
    PhoneNumber = phoneNumber;
    this.age = age;
    this.ticketClass = ticketClass;
}
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public long getPhoneNumber() {
        return PhoneNumber;
    }
    public int getAge() {
        return age;
    }
    public String getTicketClass() {
        return ticketClass;
    }
    
    

    
}
