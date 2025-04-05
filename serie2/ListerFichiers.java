package serie2;
import java.io.*;

public class ListerFichiers {
    public static void main(String[] args) {
        File dir = new File(".");

        File[] fichiers = dir.listFiles();
        for (File f : fichiers) {
            String type = f.isDirectory() ? "Dossier" : "Fichier";
            String lecture = f.canRead() ? "Lecture" : "";
            String ecriture = f.canWrite() ? "Ecriture" : "";
            System.out.println(type + " - " + lecture + " " + ecriture + " - " + f.getName());
        }
    }
}

