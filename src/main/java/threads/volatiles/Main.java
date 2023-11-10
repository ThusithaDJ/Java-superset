package threads.volatiles;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount("Acc-01", 0);

        Runnable son = new Son("Jack", account);
        Runnable mother = new Mother("Jacki", account);
        Thread motherThread = new Thread(mother);
        motherThread.start();
        Thread sonThread = new Thread(son);
        sonThread.start();

//        Vector<Double> amountList = account.getAmountList();
//        for (Double number : amountList) {
//            System.out.print("Record count : "+number+" ");
//        }
        sonThread.join();
        motherThread.join();
        System.out.println("The balance is: " + account.getBalance());
    }
}
