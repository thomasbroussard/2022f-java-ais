package fr.epita.bank.datamodel;

import java.util.List;

public class Customer {

    private String name;
    private String address;


    SavingsAccount[] savings;
    InvestmentAccount[] investmentAccounts;


    public String getName() {
        return name;
    }

    public void setName(String name){
        if (name == null){
            return;
        }
        this.name = name;
    }


}
