package oops;

public class Vechile {
    int weight;
    final int speedLimit;
    int noOfWheels;

    public Vechile(int weight, int speedLimit, int noOfWheels) {
        this.weight = weight;
        this.speedLimit = speedLimit;
        this.noOfWheels = noOfWheels;
        System.out.println("constructer of vechile is called");
    }
    public void run(){
        System.out.println("the vechile is running");
    }
    public static void brake(){
        System.out.println("brakes are being applied on vechile");
    }
    public void start(){
        System.out.println("vechile is getting started");
    }
}
