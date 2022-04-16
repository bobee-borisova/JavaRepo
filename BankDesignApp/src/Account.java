public abstract class Account {
	private final long ACCOUNT_ID;
	private static long nextAccountId = 1000;
	protected double balance;

	public Account() {
		this.ACCOUNT_ID = nextAccount_Id();
	}

	public long nextAccount_Id() {
		return nextAccountId += 5;
	}

	public long getACCOUNT_ID() {
		return ACCOUNT_ID;
	}	

	public void deposit(double amount) {
		balance += amount;
	}
	
	public double withdraw(double amount) {
		if(amount > balance) {
			return 0;
		}else {
			balance -= amount;
			return balance;
		}
	}
	
	public void correctBalance(double amount) {
		balance = amount;
	}

	public double getBalance() {
		return balance;
	}
}