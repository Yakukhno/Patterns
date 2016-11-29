package ua.training.chain_of_responsibility;

public class ChainOfResponsibilityApp {
    public static void main(String[] args) {
        Logger smsLogger = new SMSLogger(Level.ERROR);
        Logger fileLogger = new FileLogger(Level.DEBUG);
        Logger emailLogger = new EmailLogger(Level.INFO);

        smsLogger.setNext(fileLogger);
        fileLogger.setNext(emailLogger);

        smsLogger.writeMessage("All is OK", Level.INFO);
        smsLogger.writeMessage("Debugging", Level.DEBUG);
        smsLogger.writeMessage("System is down", Level.ERROR);
    }
}

interface Level {
    int ERROR = 1;
    int DEBUG = 2;
    int INFO = 3;
}

abstract class Logger {
    protected int priority;
    protected Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    abstract void writeMessage(String message, int level);

    public void setNext(Logger next) {
        this.next = next;
    }
}

class SMSLogger extends Logger {

    public SMSLogger(int priority) {
        super(priority);
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("SMS " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

class FileLogger extends Logger {

    public FileLogger(int priority) {
        super(priority);
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("File " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}

class EmailLogger extends Logger {

    public EmailLogger(int priority) {
        super(priority);
    }

    @Override
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("Email " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }
}
