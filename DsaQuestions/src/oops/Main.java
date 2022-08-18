package oops;

import rough.FractionToDecimal;

public class Main {
    int count = 0;

    public static void main(String[] args) {

        Mobile iphone = new Mobile(4, 4000, 128, "ios", "iphone");
        System.out.println(iphone.name);
        System.out.println(iphone.battery);
        // Mobile galaxy= new Mobile(8,4500,256,"Android","S20");
        // Mobile Google= new Mobile(4,4000,128,"Android","pixel");
        // galaxy.printDeatails();
        // iphone.printDeatails();
        // Google.printDeatails();
        // iphone.ram=8;
        iphone.name = "13 pro";
        iphone.printDeatails();
        FractionToDecimal f = new FractionToDecimal();
        f.decimal(3, 4);
        Main m = new Main();

        // count=1;
        m.check();
        a(20, 30);
        // Bike b= new Bike();
        // Vechile v= new Vechile(100,250,2);
        // v.brake();
        Vechile.brake();

    }

    public void check() {
        count = 1;
        System.out.println(count);
        evaluate();
    }

    public void evaluate() {
        System.out.println("i am being evaluated");
    }

    public static void a(int a, int b) {
        System.out.println("a is called");
        System.out.println(b);
    }

    public static void a(long a, int b) {
        System.out.println("b is called");
    }

}
