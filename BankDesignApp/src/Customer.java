import java.util.ArrayList;

public abstract class Customer {
    
	private final long CUSTOMER_ID;
	private static long nextCustomerId = 2000000;
	private String name; 
	private String address;
	private ArrayList<Account> accounts;
	

	public Customer(String name, String address) {
		super();
		this.CUSTOMER_ID = nextCustomer_Id();
		this.name = name;
		this.address = address;
	} 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long nextCustomer_Id() {
		return nextCustomerId += 7;
	}
	
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		accounts.remove(account);
	}
	
	public abstract void chargeAllAccounts(double amount);
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public long getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
}