package timer;

public class Timer implements Runnable {
    private String name;
    private int secs = 0;
    public boolean isRunning = false;

    public Timer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        secs = 0;
        isRunning = true;
        while (true) {
            if (isRunning) {
                try {
                    Thread.sleep(999);
                    secs++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    

    public String getName() {
        return name;
    }

    public int getSecs() {
        return secs;
    }

    @Override
    public String toString() {
        return  name + ": " + secs;
    }
}
