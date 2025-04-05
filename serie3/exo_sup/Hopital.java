package exo_sup;
class Chambre {
    private boolean medecinDansChambre = false;
    private int nbVisiteurs = 0;

    public synchronized void entrerMedecin(String nom) throws InterruptedException {
        while (medecinDansChambre || nbVisiteurs > 0) {
            wait();
        }
        medecinDansChambre = true;
        System.out.println("Médecin " + nom + " entre.");
    }

    public synchronized void sortirMedecin(String nom) {
        medecinDansChambre = false;
        System.out.println("Médecin " + nom + " sort.");
        notifyAll();
    }

    public synchronized void entrerVisiteur(String nom) throws InterruptedException {
        while (medecinDansChambre || nbVisiteurs >= 4) {
            wait();
        }
        nbVisiteurs++;
        System.out.println("Visiteur " + nom + " entre. Total: " + nbVisiteurs);
    }

    public synchronized void sortirVisiteur(String nom) {
        nbVisiteurs--;
        System.out.println("Visiteur " + nom + " sort. Restants: " + nbVisiteurs);
        notifyAll();
    }
}

class Medecin extends Thread {
    private Chambre c;
    private String nom;

    public Medecin(Chambre c, String nom) {
        this.c = c;
        this.nom = nom;
    }

    public void run() {
        try {
            c.entrerMedecin(nom);
            Thread.sleep(1000);
            c.sortirMedecin(nom);
        } catch (InterruptedException e) {}
    }
}

class Visiteur extends Thread {
    private Chambre c;
    private String nom;

    public Visiteur(Chambre c, String nom) {
        this.c = c;
        this.nom = nom;
    }

    public void run() {
        try {
            c.entrerVisiteur(nom);
            Thread.sleep(1000);
            c.sortirVisiteur(nom);
        } catch (InterruptedException e) {}
    }
}

public class Hopital {
    public static void main(String[] args) {
        Chambre chambre = new Chambre();

        new Medecin(chambre, "Dr A").start();
        new Visiteur(chambre, "V1").start();
        new Visiteur(chambre, "V2").start();
        new Visiteur(chambre, "V3").start();
        new Visiteur(chambre, "V4").start();
        new Medecin(chambre, "Dr B").start();
    }
}
