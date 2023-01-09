package fr.epita.bank.datamodel;

public class InvestmentAccount {
    private Account coreAccount;


    public InvestmentAccount(Account coreAccount) {
        this.coreAccount = coreAccount;
    }

    public Account getCoreAccount() {
        return coreAccount;
    }

    public void setCoreAccount(Account coreAccount) {
        this.coreAccount = coreAccount;
    }
}
