package exo1;
class Thd2 extends Thread {
    private Resource resource;

    public Thd2(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 26; i++) {
            resource.addInt(i);
            try {
                Thread.sleep(10); // Simuler un délai
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}