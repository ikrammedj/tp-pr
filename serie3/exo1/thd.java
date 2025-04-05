package exo1;
class Thd1 extends Thread {
    private Resource resource;

    public Thd1(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 26; i++) {
            resource.addChar(i);
            try {
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

