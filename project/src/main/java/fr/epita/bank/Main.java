package fr.epita.bank;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //initialize a customer with 2 accounts, 1 saving, 1 investment, initialized respectively with 200€.
        //then we compute the interest of the savings account (annual calculation), with a yearly interest rate of
        // 1.5%
        //then we buy from the customer investment account 2 stocks :
        // -gold : unit price: 1000€, 1 quantity
        // -silver: unit price: 200€, 2 quantity

        Customer quentin = new Customer();
        quentin.setAddress("Paris");
        quentin.setName("Quentin Lemouneau");

        InvestmentAccount[] investmentAccounts = new InvestmentAccount[5];

        investmentAccounts[0] = new InvestmentAccount(new Account(200.0));
        quentin.setInvestmentAccounts(investmentAccounts);

        //if someone wants a list, look hereafter:
//        List<InvestmentAccount> investmentAccountList = new ArrayList<>();
//        investmentAccountList.add(new InvestmentAccount());


        SavingsAccount[] savingsAccountsArray = new SavingsAccount[5];
        SavingsAccount savingsAccount = new SavingsAccount(0.015, new Account(200.0));
        savingsAccountsArray[0] = savingsAccount;
        double balance = savingsAccount.getAccount().getBalance();
        double totalInterests = balance * savingsAccount.getInterestRate();
        System.out.println("total interests: " + totalInterests);


    }

}