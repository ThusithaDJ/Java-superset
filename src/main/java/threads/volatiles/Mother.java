package threads.volatiles;

public class Mother implements Runnable {
	
	private String name;
	private BankAccount account;
	
	

	public Mother(String name, BankAccount account) {
		super();
		this.name = name;
		this.account = account;
	}



	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				double balance = account.deposite(5000);
				System.out.println(Thread.currentThread().getName() + " " + this.name +  " after deposite of 5000 account balance: "+balance + " record count: "+ account.getAmountList().size());
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Interrupted while sleeping");
			}
		}

	}

}
