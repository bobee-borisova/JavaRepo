public class CheckingAccount extends Account {
	private int nextCheckNumber = 1;

	public CheckingAccount() {
		super();
	}

    public int getNextCheckNumber() {
		nextCheckNumber ++;
		return nextCheckNumber;	
	}
}