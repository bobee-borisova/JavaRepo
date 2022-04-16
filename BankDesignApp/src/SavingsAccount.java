public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount() {
        super();
    }

    public void addInterest() {
        interestRate = balance * interestRate / 100;
        balance += interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        deposit(amount);
    }

    @Override
    public double withdraw(double amount) {
        if (balance - amount > 0) {
            withdraw(amount);
            return amount;
        }
        return 0;
    }

}
