package com.example.myfx;

public class Cargo{
    private  double weight;
    private  double perkm;
    private  double duration;
    private  String destination;
    private  boolean fastTrack;
    private  String origin;

    public Cargo(double weight, String destination, boolean fastTrack, String origin) {
        this.weight = weight;
        this.destination = destination;
        this.fastTrack = fastTrack;
        this.origin = origin;
    }

    public double getWeight() {
        return weight;
    }

    public double getPerkm() {
        return perkm;
    }

    public double getDuration() {
        return duration;
    }

    public String getDestination() {
        return destination;
    }


    public boolean isFastTrack() {
        return fastTrack;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public static double cargofare(double weight,String destination , boolean isFastTrack, String origin ){
        double total=0;
        double duration=0;
        final  double perkm=1000;

        if (destination.equalsIgnoreCase("Islamabad")&&origin.equalsIgnoreCase("Lahore")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("London")&&origin.equalsIgnoreCase("Lahore")){
            duration=8.5;
            total = weight * perkm * duration ;
        }else  if (destination.equalsIgnoreCase("newyork")&&origin.equalsIgnoreCase("Lahore")){
            duration=22;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("doha")&&origin.equalsIgnoreCase("Lahore")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("dubai")&&origin.equalsIgnoreCase("Lahore")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("islamabad")&&origin.equalsIgnoreCase("karachi")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("london")&&origin.equalsIgnoreCase("karachi")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("newyork")&&origin.equalsIgnoreCase("karachi")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("doha")&&origin.equalsIgnoreCase("karachi")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("dubai")&&origin.equalsIgnoreCase("karachi")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("islamabad")&&origin.equalsIgnoreCase("multan")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("newyork")&&origin.equalsIgnoreCase("multan")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("london")&&origin.equalsIgnoreCase("multan")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("doha")&&origin.equalsIgnoreCase("multan")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("dubai")&&origin.equalsIgnoreCase("multan")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("islamabad")&&origin.equalsIgnoreCase("faisalabad")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("newyork")&&origin.equalsIgnoreCase("faisalabad")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("doha ")&&origin.equalsIgnoreCase("faisalabad")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("dubai ")&&origin.equalsIgnoreCase("faisalabad")){
            duration=1.5;
            total = weight * perkm * duration ;
        }else if (destination.equalsIgnoreCase("london ")&&origin.equalsIgnoreCase("faisalabad")){
            duration=1.5;
            total = weight * perkm * duration ;
        }
        if (isFastTrack){
            total+=10000;
        }
        return  total;
    }
}
