package serie2;
import java.io.*;
import java.util.*;

class Book implements Serializable {
    private String title;
    private String author;
    private int year;

    public Book(String t, String a, int y) {
        title = t;
        author = a;
        year = y;
    }

    public String toString() {
        return title + " - " + author + " - " + year;
    }
}

public class ListeLivre {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("livres.dat"));
        ArrayList<Book> livres = new ArrayList<>();
        livres.add(new Book("1984", "George Orwell", 1949));
        livres.add(new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
        oos.writeObject(livres);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("livres.dat"));
        ArrayList<Book> livresLus = (ArrayList<Book>) ois.readObject();
        for (Book b : livresLus) {
            System.out.println(b);
        }
        ois.close();
    }
}

