package fr.epita.bank.datamodel;

public class SavingsAccount {
    private double interestRate;
    private Account account;

    public SavingsAccount(double interestRate, Account account) {
        this.interestRate = interestRate;
        this.account = account;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
