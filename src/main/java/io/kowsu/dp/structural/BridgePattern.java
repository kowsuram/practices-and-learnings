package io.kowsu.dp.structural;

public class BridgePattern {

    //Driver class
    public static void main(String[] args) {
        //Build a Sedan car with fuel type as Petrol
        String sedanPetrolCarSpec = new Sedan(new Petrol()).detailedSpec();
        String hatchbackDieselCarSpec = new Hatchback(new Diesel()).detailedSpec();
        System.out.printf("Sedan Spec -------------------> %s \n", sedanPetrolCarSpec);
        System.out.printf("Hatchback Spec -------------------> %s \n", hatchbackDieselCarSpec);
    }
}

enum FuelType {
    PETROL, DIESEL;
}

abstract class Car {
    private Fuel fuel;
    public Car(Fuel fuel) {
        this.fuel = fuel;
    }
    abstract Integer getSeatingCapacity();

    public String detailedSpec() {
        return String.format(
                "Car has %d seaters and it runs with fuel type as %s",
                getSeatingCapacity(),
                fuel.getFuelType()
        );
    }
}

interface Fuel {
    FuelType getFuelType();
}


class Sedan extends Car {
    Fuel fuel;
    public Sedan(Fuel fuel) {
        super(fuel);
        this.fuel = fuel;
    }
    @Override
    public Integer getSeatingCapacity() {
        return 5;
    }

}

class Hatchback extends Car {
    private Fuel fuel;
    public Hatchback(Fuel fuel) {
        super(fuel);
        this.fuel = fuel;
    }
    @Override
    public Integer getSeatingCapacity() {
        return 4;
    }
}

class Petrol implements Fuel {
    @Override
    public FuelType getFuelType() {
        return FuelType.PETROL;
    }
}


class Diesel implements Fuel {
    @Override
    public FuelType getFuelType() {
        return FuelType.DIESEL;
    }
}