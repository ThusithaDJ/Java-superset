package threads.synchronize;

public class BankAccount {

	private String accNo;
	private double balance;
	
	public BankAccount(String accNo, double balance) {
		super();
		this.accNo = accNo;
		this.balance = balance;
	}
	
	public synchronized double deposite(double amount) {
		this.balance += amount;
		return this.balance;
	}
	
	public synchronized double withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
		} else {
			throw new IllegalArgumentException("Insuficient funds");
		}
		return this.balance;
	}
}
