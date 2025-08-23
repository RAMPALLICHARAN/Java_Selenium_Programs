package Sample_Day5_Programs;

abstract class VehicleDrive {
    abstract void speed();
    abstract void brand();
}


class Car extends VehicleDrive {
    @Override
    void speed() {
        System.out.println("Speed of the car: 120 km/hr  ");
    }

    @Override
    void brand() {
        System.out.println("Brand: Audi");
    }
}


class Bike extends VehicleDrive {
    @Override
    void speed() {
        System.out.println("Speed of the bike: 80 km/hr");
    }

    @Override
    void brand() {
        System.out.println("Brand: Yamaha");
    }
}

public class Abstract_Program {
    public static void main(String[] args) {
        VehicleDrive car = new Car();
        car.speed();
        car.brand();

        System.out.println(" ");

        VehicleDrive bike = new Bike();
        bike.speed();
        bike.brand();
    }
}



