package fr.epita.bank.datamodel;


public class StockOrder {

    Stock refStock;
    InvestmentAccount account;

    String date;
    double unitPrice;
    int quantity;
    double commission;

    public StockOrder(Stock refStock,
                      InvestmentAccount account,
                      String date,
                      double unitPrice,
                      int quantity,
                      double commission) {
        this.refStock = refStock;
        this.account = account;
        this.date = date;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.commission = commission;
    }

    public Stock getRefStock() {
        return refStock;
    }

    public void setRefStock(Stock refStock) {
        this.refStock = refStock;
    }

    public InvestmentAccount getAccount() {
        return account;
    }

    public void setAccount(InvestmentAccount account) {
        this.account = account;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }


    @Override
    public String toString() {
        return "StockOrder{" +
                "refStock=" + refStock +
                ", account=" + account +
                ", date='" + date + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", commission=" + commission +
                '}';
    }
}
