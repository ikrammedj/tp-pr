package exo_sup;
class SommeThread extends Thread {
    private int[] tableau;
    private int debut, fin;
    private int sommePartielle = 0;

    public SommeThread(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
    }

    public void run() {
        for (int i = debut; i < fin; i++) {
            sommePartielle += tableau[i];
        }
    }

    public int getSommePartielle() {
        return sommePartielle;
    }
}

public class SommeConcurrente {
    public static void main(String[] args) throws InterruptedException {
        int taille = 10000;
        int[] tableau = new int[taille];
        for (int i = 0; i < taille; i++) {
            tableau[i] = 1; // Ou toute autre valeur
        }

        int nbThreads = 10;
        SommeThread[] threads = new SommeThread[nbThreads];
        int pas = taille / nbThreads;

        for (int i = 0; i < nbThreads; i++) {
            int debut = i * pas;
            int fin = (i == nbThreads - 1) ? taille : debut + pas;
            threads[i] = new SommeThread(tableau, debut, fin);
            threads[i].start();
        }

        int sommeTotale = 0;
        for (int i = 0; i < nbThreads; i++) {
            threads[i].join();
            sommeTotale += threads[i].getSommePartielle();
        }

        System.out.println("Somme totale : " + sommeTotale);
    }
}
