package exo_sup;
class Alternance {
    private boolean tourPair = true;

    public synchronized void afficherPair(int n) {
        while (!tourPair) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("Pair: " + n);
        tourPair = false;
        notify();
    }

    public synchronized void afficherImpair(int n) {
        while (tourPair) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("Impair: " + n);
        tourPair = true;
        notify();
    }
}

class PairThread extends Thread {
    Alternance a;

    PairThread(Alternance a) {
        this.a = a;
    }

    public void run() {
        for (int i = 0; i <= 20; i += 2) {
            a.afficherPair(i);
        }
    }
}

class ImpairThread extends Thread {
    Alternance a;

    ImpairThread(Alternance a) {
        this.a = a;
    }

    public void run() {
        for (int i = 1; i < 20; i += 2) {
            a.afficherImpair(i);
        }
    }
}

public class TestAlternance {
    public static void main(String[] args) {
        Alternance a = new Alternance();
        new PairThread(a).start();
        new ImpairThread(a).start();
    }
}
