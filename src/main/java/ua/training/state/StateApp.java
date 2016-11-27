package ua.training.state;

public class StateApp {
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setStation(new PerezFMStation());
        radio.play();
        radio.play();
        radio.play();
        radio.play();
    }
}

interface Station {
    void play(Radio radio);
}

class AutoRadioStation implements Station{
    public void play(Radio radio) {
        System.out.println("auto radio");
        radio.setStation(new PerezFMStation());
    }
}

class PerezFMStation implements Station{
    public void play(Radio radio) {
        System.out.println("perez fm");
        radio.setStation(new ChansonStation());
    }
}
class ChansonStation implements Station{
    public void play(Radio radio) {
        System.out.println("chanson");
        radio.setStation(new AutoRadioStation());
    }
}

class Radio {
    private Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    public void play() {
        station.play(this);
    }
}

