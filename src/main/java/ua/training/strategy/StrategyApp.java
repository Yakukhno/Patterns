package ua.training.strategy;

public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient strategyClient = new StrategyClient(new BubbleSort());
        int[] array = {1, 2, 3};

        strategyClient.executeSorting(array);

        strategyClient.setStrategy(new QuickSort());
        strategyClient.executeSorting(array);
    }
}

class StrategyClient {
    private Sorting strategy;

    public StrategyClient(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeSorting(int[] array) {
        strategy.sort(array);
    }

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
}

interface Sorting {
    void sort(int[] array);
}

class BubbleSort implements Sorting {

    @Override
    public void sort(int[] array) {
        System.out.println("bubble sort");
    }
}

class QuickSort implements Sorting {

    @Override
    public void sort(int[] array) {
        System.out.println("quick sort");
    }
}