package bank;

/**
 * BankAccount class - shows encapsulation
 * All fields are private, access through getters/setters
 * Has validation to prevent invalid states (like negative balance)
 */
public class BankAccount {

    private String accountNumber;
    private String holder;
    private double balance;
    private String accountType;
    private boolean active;
    private String pin;

    private static int accountCounter = 0;

    public BankAccount(String holder, double initialBalance, String accountType) {
        accountCounter++;
        this.accountNumber = "ACC-" + String.format("%04d", accountCounter);
        this.holder = holder;
        this.balance = initialBalance > 0 ? initialBalance : 0;
        this.accountType = accountType;
        this.active = true;
        this.pin = "0000"; // default pin
        System.out.println("Account created: " + accountNumber);
    }

    // getters - reading data

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean isActive() {
        return active;
    }
    // no getter for pin! its private

    // setters with validation

    public void setHolder(String holder) {
        if (holder != null && !holder.trim().isEmpty()) {
            this.holder = holder;
        }
    }

    public boolean changePin(String currentPin, String newPin) {
        if (this.pin.equals(currentPin) && newPin.length() == 4) {
            this.pin = newPin;
            System.out.println("PIN changed successfully");
            return true;
        }
        System.out.println("Error: wrong pin or invalid new pin");
        return false;
    }

    // business logic methods

    public boolean deposit(double amount) {
        if (!active) {
            System.out.println("Error: account is inactive");
            return false;
        }
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " | New balance: $" + balance);
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount, String pin) {
        if (!active) {
            System.out.println("Error: account is inactive");
            return false;
        }
        if (!this.pin.equals(pin)) {
            System.out.println("Error: wrong PIN");
            return false;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " | New balance: $" + balance);
            return true;
        }
        System.out.println("Error: insufficient funds");
        return false;
    }

    public void showInfo() {
        System.out.println("--- Account Info ---");
        System.out.println("Number: " + accountNumber);
        System.out.println("Holder: " + holder);
        System.out.println("Balance: $" + balance);
        System.out.println("Type: " + accountType);
        System.out.println("Active: " + (active ? "Yes" : "No"));
        System.out.println("--------------------");
    }

    @Override
    public String toString() {
        return "BankAccount[" + accountNumber + ", " + holder + ", $" + balance + "]";
    }
}
