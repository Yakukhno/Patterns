package ua.training.decorator;

public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInterface printer = new LeftBracketDecorator(
                new RightBracketDecorator(
                        new QuotesDecorator(new PrinterCanon())));
        printer.print("Hello");
    }
}

interface PrinterInterface {
    void print(String string);
}

class PrinterCanon implements PrinterInterface {
    public void print(String string) {
        System.out.print(string + " by Canon");
    }
}

abstract class AbstractDecorator implements PrinterInterface {
    protected PrinterInterface printer;

    protected AbstractDecorator(PrinterInterface printer) {
        this.printer = printer;
    }
}

class QuotesDecorator extends AbstractDecorator {

    public QuotesDecorator(PrinterInterface printer) {
        super(printer);
    }

    public void print(String string) {
        System.out.print("\"");
        printer.print(string);
        System.out.print("\"");
    }
}

class LeftBracketDecorator extends AbstractDecorator {

    public LeftBracketDecorator(PrinterInterface printer) {
        super(printer);
    }

    public void print(String string) {
        System.out.print("[");
        printer.print(string);
    }
}

class RightBracketDecorator extends AbstractDecorator {

    public RightBracketDecorator(PrinterInterface printer) {
        super(printer);
    }

    public void print(String string) {
        printer.print(string);
        System.out.print("]");
    }
}