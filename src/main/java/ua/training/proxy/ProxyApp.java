package ua.training.proxy;

import java.io.IOException;

public class ProxyApp {
    public static void main(String[] args) throws IOException {
        IMath math = new MathProxy();
        math.add(2,3);
        math.sub(2,3);
        math.mul(2,3);
        math.div(2,3);
    }
}

interface IMath {

    double add(double x, double y);

    double sub(double x, double y);

    double mul(double x, double y);

    double div(double x, double y);
}

class Math implements IMath {

    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        return x / y;
    }
}

class MathProxy implements IMath {

    private Math math;

    public double add(double x, double y) {
        if (math == null) {
            math = new Math();
        }
        return math.add(x, y);
    }

    public double sub(double x, double y) {
        if (math == null) {
            math = new Math();
        }
        return math.sub(x, y);
    }

    public double mul(double x, double y) {
        if (math == null) {
            math = new Math();
        }
        return math.mul(x, y);
    }

    public double div(double x, double y) {
        if (math == null) {
            math = new Math();
        }
        return math.div(x, y);
    }
}
