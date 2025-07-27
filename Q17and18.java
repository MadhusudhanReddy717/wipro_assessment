package assessment;

class Vehicle {
    String color;
    int wheels;
    String model;

    Vehicle(String color, int wheels, String model) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
    }

    void start() {
        System.out.println(model + " engine started.");
    }

    void stop() {
        System.out.println(model + " engine stopped.");
    }
}

class Truck extends Vehicle {
    Truck() {
        super("Blue", 6, "Volvo Truck");
    }

    void loadCargo() {
        System.out.println("Truck is loading cargo.");
    }
}

class Bus extends Vehicle {
    Bus() {
        super("Yellow", 4, "City Bus");
    }

    void pickPassengers() {
        System.out.println("Bus is picking up passengers.");
    }
}

class Car extends Vehicle {
    Car() {
        super("Red", 4, "Sedan Car");
    }

    void playMusic() {
        System.out.println("Car is playing music.");
    }
}

class Lion {
    String color = "Golden";
    int weight = 190;
    int age = 8;

    boolean isVegetarian() { return false; }
    boolean canClimb() { return true; }
    String sound() { return "Roar"; }
}

class Deer {
    String color = "Brown";
    int weight = 90;
    int age = 4;

    boolean isVegetarian() { return true; }
    boolean canClimb() { return false; }
    String sound() { return "Bleat"; }
}

class Monkey {
    String color = "Black";
    int weight = 50;
    int age = 5;

    boolean isVegetarian() { return true; }
    boolean canClimb() { return true; }
    String sound() { return "Chatter"; }
}

public class Q17and18 {

    public void q17() {
        Truck truck = new Truck();
        Bus bus = new Bus();
        Car car = new Car();

        System.out.println("Q17: Vehicle Demonstration:");
        truck.start();
        truck.loadCargo();
        truck.stop();

        bus.start();
        bus.pickPassengers();
        bus.stop();

        car.start();
        car.playMusic();
        car.stop();
    }

    public void q18() {
        Lion lion = new Lion();
        Deer deer = new Deer();
        Monkey monkey = new Monkey();

        System.out.println("\nQ18: Animal Characteristics in Vandalur Zoo:");
        System.out.println("Lion: Vegetarian: " + lion.isVegetarian() + ", Can Climb: " + lion.canClimb() + ", Sound: " + lion.sound());
        System.out.println("Deer: Vegetarian: " + deer.isVegetarian() + ", Can Climb: " + deer.canClimb() + ", Sound: " + deer.sound());
        System.out.println("Monkey: Vegetarian: " + monkey.isVegetarian() + ", Can Climb: " + monkey.canClimb() + ", Sound: " + monkey.sound());
    }

    public static void main(String[] args) {
        Q17and18 q = new Q17and18();
        q.q17();
        q.q18();
    }
}
