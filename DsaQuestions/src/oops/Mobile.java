package oops;

public class Mobile {
    int ram;
    int battery;
    int storage;
    String Os;
    String name;

    // constructer:
    public Mobile(int ram, int battery, int storage, String Os, String name) {
        this.ram = ram;
        this.battery = battery;
        this.storage = storage;
        this.Os = Os;
        this.name = name;
    }

     public  void printDeatails() {
        System.out.println(ram + " " + battery + " " + storage + " " + Os + " " + " " + name);
    }

    public static void main(String[] args) {
        Mobile iphone = new Mobile(4, 4000, 128, "ios", "iphone");
        iphone.ram = 8;
    }


}

class acessSpecifierTester {
    Mobile mb = new Mobile(4, 4000, 128, "ios", "iphone");


    public static void main(String[] args) {
        Mobile mb = new Mobile(4, 4000, 128, "ios", "iphone");
        mb.ram = 10;
    }

}
