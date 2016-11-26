package ua.training.builder;


public class BuilderApp {

    public static void main(String[] args) {
        Director director = new Director(new FordBuilder());
        Car car = director.buildCar();
        System.out.println(car);
    }

}

enum Transmission {
    AUTO, MANUAL
}

class Car {

    private String manufacturer;
    private Transmission transmission;
    private int maxSpeed;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

abstract class CarBuilder {

    protected Car car;

    public void createCar() {
        car = new Car();
    }

    public Car getCar() {
        return car;
    }

    abstract void buildManufacturer();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();
}

class FordBuilder extends CarBuilder {

    @Override
    public void buildManufacturer() {
        car.setManufacturer("Ford");
    }

    @Override
    public void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    public void buildMaxSpeed() {
        car.setMaxSpeed(200);
    }
}

class MercedesBuilder extends CarBuilder {

    @Override
    public void buildManufacturer() {
        car.setManufacturer("Mercedes");
    }

    @Override
    public void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    public void buildMaxSpeed() {
        car.setMaxSpeed(260);
    }
}

class Director {

    CarBuilder builder;

    public Director(CarBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    public Car buildCar() {
        builder.createCar();
        builder.buildManufacturer();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        return builder.getCar();
    }

}




