package exo2;
class SumThread extends Thread {
    private int start, end;
    private long partialSum;

    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
        this.partialSum = 0;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            partialSum += i;
        }
    }

    public long getPartialSum() {
        return partialSum;
    }
}
