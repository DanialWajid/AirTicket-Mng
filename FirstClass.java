public class FirstClass implements Fare {
    private  double  superTax;
    private double baseFare;
   private double tax;
   private double discount;
   public FirstClass(String name, String email, long phoneNumber, int age, String ticketClass, double superTax,
           double baseFare, double tax, double discount) {
       super(name, email, phoneNumber, age, ticketClass);
       this.superTax = superTax;
       this.baseFare = baseFare;
       this.tax = tax;
       this.discount = discount;
   }
   @Override
   public double getBaseFare() {
       return baseFare;
   }

   @Override
   public double getTax() {
       return tax;
   }

   @Override
   public double getDiscount() {
       return discount;
   }

   @Override
   public double calculateFare() {
       return baseFare + tax - discount + superTax;
   }

   public double getSuperTax() {
       return superTax;
   }
   


    




}
