package oops;

public class Bike extends Vechile{
   int engineSpec;
   int avg;
   String Company;

    public Bike(int weight, int speedLimit, int noOfWheels, int engineSpec, int avg, String company) {
        super(weight, speedLimit, noOfWheels);
        this.engineSpec = engineSpec;
        this.avg = avg;
        Company = company;
        System.out.println("constructor of bike is called");
    }
    public void run(){
        System.out.println("Bike is running");
    }
    public void turnIndicator(){
        System.out.println("left or right turn indicator is give to bike");
    }
}
