package serie2;
import java.io.*;
import java.util.*;



public class LectTxt2 {
    public static void main(String[] args) throws IOException {
        String nomfich = "nomber.txt";
        int nombre, carre;

        BufferedReader entree = new BufferedReader(new FileReader(nomfich));
        PrintWriter sortie = new PrintWriter(new FileWriter("resultat.txt"));

        System.out.println("Nombres et carrés contenus dans ce fichier :");
        while (true) {
            String ligneLue = entree.readLine();
            if (ligneLue == null) break;

            StringTokenizer tok = new StringTokenizer(ligneLue, " ");
            Vector<Integer> nbrs = new Vector<>();

            while (tok.hasMoreTokens())
                nbrs.add(Integer.parseInt(tok.nextToken()));

            for (int nbr : nbrs) {
                carre = (int) Math.pow(nbr, 2);
                if (nbrs.contains(carre)) {
                    System.out.println(nbr + " " + carre);
                    sortie.println(nbr + " " + carre);
                }
            }
        }

        entree.close();
        sortie.close();
    }
}
