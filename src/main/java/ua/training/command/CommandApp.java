package ua.training.command;

public class CommandApp {
    public static void main(String[] args) {
        ElectronicDevice tv = new Television();
        TVRemote tvRemote = new TVRemote(new TVOffCommand(tv));
        tvRemote.pressButton();
    }
}

interface ElectronicDevice {
    void on();
    void off();
}

class Television implements ElectronicDevice {

    @Override
    public void on() {
        System.out.println("Television is on");
    }

    @Override
    public void off() {
        System.out.println("Television is off");
    }
}

interface Command {
    void execute();
}

class TVOnCommand implements Command {

    private ElectronicDevice electronicDevice;

    public TVOnCommand(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.on();
    }
}

class TVOffCommand implements Command {

    private ElectronicDevice electronicDevice;

    public TVOffCommand(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    @Override
    public void execute() {
        electronicDevice.off();
    }
}

class TVRemote {

    private Command command;

    public TVRemote(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

}