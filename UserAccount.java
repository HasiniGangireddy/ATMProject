public class UserAccount {
    private String userId;
    private String pin;
    private double balance;

    public UserAccount(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String pin) {
        return this.pin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}