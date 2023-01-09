package fr.epita.bank.datamodel;

import java.util.Arrays;

public class Customer {

    private SavingsAccount[] savings;
    private InvestmentAccount[] investmentAccounts;
    private String name;
    private String address;

    public SavingsAccount[] getSavings() {
        return savings;
    }

    public void setSavings(SavingsAccount[] savings) {
        this.savings = savings;
    }

    public InvestmentAccount[] getInvestmentAccounts() {
        return investmentAccounts;
    }

    public void setInvestmentAccounts(InvestmentAccount[] investmentAccounts) {
        this.investmentAccounts = investmentAccounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            return;
        }
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "savings=" + Arrays.toString(savings) +
                ", investmentAccounts=" + Arrays.toString(investmentAccounts) +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
