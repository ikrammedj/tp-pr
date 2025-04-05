package serie2;

import java.io.*;
import java.util.*;

public class MotMiroir {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        HashMap<String, Integer> freqs = new HashMap<>();
        ArrayList<String> mots = new ArrayList<>();

        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] tokens = ligne.split(" ");
            for (String mot : tokens) {
                mots.add(mot);
                freqs.put(mot, freqs.getOrDefault(mot, 0) + 1);
            }
        }

        String motMax = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : freqs.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                motMax = entry.getKey();
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("text-modifie.txt"));
        for (String mot : mots) {
            if (mot.equals(motMax)) {
                bw.write(new StringBuilder(mot).reverse().toString() + " ");
            } else {
                bw.write(mot + " ");
            }
        }

        br.close();
        bw.close();
    }
}

