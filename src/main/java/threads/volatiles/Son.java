package threads.volatiles;

public class Son implements Runnable {
	
	private String name;
	private BankAccount account;
	
	

	public Son(String name, BankAccount account) {
		super();
		this.name = name;
		this.account = account;
	}



	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				double balance = account.withdraw(5000);
				System.out.println(Thread.currentThread().getName() + " " + this.name + " after withdraw of 5000 account balance: "+balance + " record count: "+ account.getAmountList().size());
				Thread.sleep(1000);
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}catch (Exception e) {
				System.out.println("Interrupted while sleeping");
			}
		}

	}

}
