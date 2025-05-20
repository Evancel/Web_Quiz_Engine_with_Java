class NumbersThread extends Thread {
    private int fromNumber;
    private int toNumber;

    public NumbersThread(int from, int to) {
        // implement the constructor
        this.fromNumber = from;
        this.toNumber = to;
    }

    // you should override some method here
    @Override
    public void run() {
        for (int i = fromNumber; i <= toNumber; i++) {
            System.out.println(i);
        }
    }
}