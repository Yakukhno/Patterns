package ua.training.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Graphic circle1 = new Circle();
        Graphic circle2 = new Circle();
        Graphic circle3 = new Circle();
        Graphic square1 = new Square();
        Graphic square2 = new Square();

        CompositeGraphic container1 = new CompositeGraphic();
        CompositeGraphic container2 = new CompositeGraphic();
        CompositeGraphic container3 = new CompositeGraphic();

        container2.add(circle2);

        container3.add(circle3);
        container3.add(square2);

        container2.add(container3);

        container1.add(circle1);
        container1.add(square1);
        container1.add(container2);

        container1.print();

        container2.remove(container3);
        System.out.println("===================");
        container1.print();
    }
}

interface Graphic {
    void print();
}

class Circle implements Graphic {

    public void print() {
        System.out.println("circle");
    }
}

class Square implements Graphic {

    public void print() {
        System.out.println("square");
    }
}

class CompositeGraphic implements Graphic {

    private List<Graphic> components = new ArrayList<>();

    public void print() {
        components.forEach(Graphic::print);
    }

    public void add(Graphic graphic) {
        components.add(graphic);
    }

    public void remove(Graphic graphic) {
        components.remove(graphic);
    }
}