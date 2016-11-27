package ua.training.abstract_factory;

import java.time.LocalDateTime;

public class AbstractFactoryApp {
    public static void main(String[] args) {
        DeviceFactory factory = getDeviceFactory("Rome");
        Watch watch = factory.createWatch();
        watch.showTime();

        factory = getDeviceFactory("Digital");
        Scales scales = factory.createScales();
        scales.showWeight();
    }

    public static DeviceFactory getDeviceFactory(String factory) {
        switch (factory.toLowerCase()) {
            case "digital":
                return new DigitalFactory();
            case "rome":
                return new RomeFactory();
            default:
                throw new RuntimeException("Unknown factory");
        }
    }
}

interface Watch {
    void showTime();
}

interface Scales {
    void showWeight();
}

interface DeviceFactory {
    Watch createWatch();
    Scales createScales();
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(LocalDateTime.now());
    }
}

class RomeWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("XX-XVI");
    }
}

class DigitalScales implements Scales {

    @Override
    public void showWeight() {
        System.out.println("digital weight");
    }
}

class RomeScales implements Scales {

    @Override
    public void showWeight() {
        System.out.println("rome weight");
    }
}

class DigitalFactory implements DeviceFactory {

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }

    @Override
    public Scales createScales() {
        return new DigitalScales();
    }
}

class RomeFactory implements DeviceFactory {

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }

    @Override
    public Scales createScales() {
        return new RomeScales();
    }
}


