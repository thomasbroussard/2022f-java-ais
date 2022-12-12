package fr.epita.bank;

import fr.epita.bank.datamodel.*;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static List<StockOrder> placedOrders;

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


        Stock goldStock = new Stock("gold");
        goldStock.setCurrentValue(1000.0);

        Stock silverStock = new Stock("silver");
        silverStock.setCurrentValue(200.0);


        placedOrders = new ArrayList<>();

        // FIXME check the commission calculation
        StockOrder goldStockOrder = new StockOrder(goldStock,
                quentin.getInvestmentAccounts()[0],
                "2022-12-01",
                goldStock.getCurrentValue(),
                1,
                10
        );

        placedOrders.add(goldStockOrder);

        // FIXME check the commission calculation
        StockOrder silverStockOrder = new StockOrder(silverStock,
                quentin.getInvestmentAccounts()[0],
                "2022-12-01",
                silverStock.getCurrentValue(),
                2,
                1
        );

        placedOrders.add(silverStockOrder);

    }

}