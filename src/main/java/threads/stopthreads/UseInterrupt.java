package threads.stopthreads;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class UseInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Test());
        LocalDateTime time = LocalDateTime.now();
        t.start();

//        if the execution takes time to complete the task, we can simply call the Thread.interrupt() method
        Thread.sleep(5000);
        t.interrupt();

        t = new Thread(new LongRunningComputation(new BigInteger("10"), new BigInteger("10")));
        t.start();
    }

    private static class Test implements Runnable {
        @Override
        public void run() {
            try{
                Thread.sleep(500000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static class SleepingThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private static class LongRunningComputation implements Runnable{
        private BigInteger base;
        private BigInteger power;

        public LongRunningComputation(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) !=0; i= i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                }
                result = result.multiply(base);
            }

            return  result;
        }

        @Override
        public void run() {
            System.out.println(base +" ^ "+power +" = "+pow(base, power));
        }
    }
}
