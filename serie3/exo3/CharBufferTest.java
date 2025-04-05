package exo3;

class Buffer {
    private char[] buffer;
    private int size, count, in, out;

    public Buffer(int size) {
        this.size = size;
        buffer = new char[size];
        this.count = 0;
        this.in = 0;
        this.out = 0;
    }


    public synchronized void put(char c) {
        while (count == size) { 
            try {
                wait(); 
         } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
          }
        }
        buffer[in] = c;
        in = (in + 1) % size;
        count++;
        System.out.println("Producer put: " + c);
        notifyAll(); 
    }

    public synchronized char get() {
        while (count == 0) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        char c = buffer[out];
        out = (out + 1) % size;
        count--;
        System.out.println("Consumer got: " + c);
        notifyAll(); 
        return c;
    }
}

class Producer extends Thread {
    private Buffer buffer;
    private char c;
    private int count;

    public Producer(Buffer buffer, char c, int count) {
        this.buffer = buffer;
        this.c = c;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            char cc = (char) (c + i);
            buffer.put(cc);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
        }
        }
    }
}
class Consumer extends Thread {
    private Buffer buffer;
    private int count;

    public Consumer(Buffer buffer, int count) {
        this.buffer = buffer;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            buffer.get();
            try {
             Thread.sleep(200); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class CharBufferTest {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        Producer producer = new Producer(buffer, 'A', 10);
        Consumer consumer = new Consumer(buffer, 10);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}