package threads.stopthreads;

public class DemonThread {
    public static void main(String[] args) {
        Thread t = new Thread(new Test());
//        making the new thread as Daemon thread, avoid blocking the main thread being stop.
        t.setDaemon(true);
        t.start();

    }

    public static class Test implements Runnable {

        @Override
        public void run() {
            try{
                Thread.sleep(500000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
