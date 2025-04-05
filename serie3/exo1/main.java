package exo1;

public class main {
    public static void main(String[] args) {
        
        Resource resource = new Resource();

        
        Thd1 t1 = new Thd1(resource);
        Thd2 t2 = new Thd2(resource);

        
        t1.start();
        t2.start();

        
        try {
            t1.join();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        System.out.println("Contenu de la chaîne : " + resource.getStr());
        System.out.println("Taille de la chaîne : " + resource.getLength());
    }
}