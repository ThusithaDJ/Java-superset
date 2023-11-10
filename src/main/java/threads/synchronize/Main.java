package threads.synchronize;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount("Acc-01", 0);

        Runnable husband = new Son("Jack", account);
        Runnable wife = new Mother("Jacki", account);
        new Thread(wife).start();
        new Thread(husband).start();
    }
}
