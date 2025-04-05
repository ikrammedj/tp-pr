package serie2;

import java.io.*;
import java.util.*;

class House implements Serializable {
    private int code;
    private String address;
    private int nbRooms;
    private double price;

    public House(int code, String address, int nbRooms, double price) {
        this.code = code;
        this.address = address;
        this.nbRooms = nbRooms;
        this.price = price;
    }

    public String toString() {
        return code + " - " + address + " - " + nbRooms + " - " + price;
    }
}

public class ListeHouse {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("listeHouse.dat"));

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Donner code, adresse, nb de chambres, prix :");
            int code = sc.nextInt();
            sc.nextLine(); // Consommer le retour à la ligne
            String adresse = sc.nextLine();
            int chambres = sc.nextInt();
            double prix = sc.nextDouble();

            House h = new House(code, adresse, chambres, prix);
            oos.writeObject(h);
        }

        oos.close();
    }
}
