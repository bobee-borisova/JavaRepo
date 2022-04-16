import java.util.ArrayList;

public class AccountController {

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	public Customer createCustomer(String name, String address, String type){
		if(type.equals("person")) {
			Person person = new Person(name, address);
            customers.add(person);
            return person;
		}else if(type.equals("company")){
            Company company = new Company(name, address);
            customers.add(company);
            return company; 
        }
        return null; 
		
	}
	
	public Account createAccount(Customer customer, String type){
		if (type.equals("checking")) {
            CheckingAccount checkingAccount = new CheckingAccount();
            accounts.add(checkingAccount);
            customer.addAccount(checkingAccount);
            return checkingAccount;
        } else if (type.equals("savings")){
            SavingsAccount savingsAccount = new SavingsAccount();
            accounts.add(savingsAccount);
            customer.addAccount(savingsAccount);
            return savingsAccount;   
        }
        return null;
	}
	
	public void removeCustomer(Customer customer) {
		for (Account account : customer.getAccounts()) {
            accounts.remove(account);
        }
        customers.remove(customer);
	}
	
	public void removeAccount(Account account) {
		for (Customer customer : customers) {
            for (Account acc : customer.getAccounts()) {
                if (account.getACCOUNT_ID() == acc.getACCOUNT_ID()) {
                    customer.removeAccount(account);
                    accounts.remove(account);
                    break;
                }
            }
        }
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	
}
