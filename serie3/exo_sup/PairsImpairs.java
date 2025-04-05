package exo_sup;
class Pairs extends Thread {
    public void run() {
        for (int i = 0; i <= 20; i += 2) {
            System.out.println("Pair: " + i);
        }
    }
}

class Impairs extends Thread {
    public void run() {
        for (int i = 1; i < 20; i += 2) {
            System.out.println("Impair: " + i);
        }
    }
}

public class PairsImpairs {
    public static void main(String[] args) {
        new Pairs().start();
        new Impairs().start();
    }
}
