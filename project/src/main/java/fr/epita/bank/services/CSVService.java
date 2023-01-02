package fr.epita.bank.services;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;
import fr.epita.bank.exceptions.CSVServiceInitializationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CSVService {


    private final File file;

    public CSVService(File outputFile) throws CSVServiceInitializationException {
        if (!outputFile.exists()){
            try {
                Files.createFile(outputFile.toPath());
            }catch (IOException e){
                throw new CSVServiceInitializationException("unable to access persistent storage for csv service", e);
            }
        }
        this.file = outputFile;
    }

    public void write(StockOrder stockOrder) {
        try {
            String content = Files.readString(file.toPath());
            String newLine = System.getProperty("line.separator");
            if (content.isBlank()){

                String headers = "stockRef, accountRef, date, value, quantity, commission" + newLine;
                Files.writeString(file.toPath(), headers);
            }
            String line = stockOrder.getRefStock().getName() +","
                    + stockOrder.getAccount().getCoreAccount().getId() + ","
                    + stockOrder.getDate() + ","
                    + stockOrder.getUnitPrice() + ","
                    + stockOrder.getQuantity() + ","
                    + stockOrder.getCommission() + newLine;

            Files.writeString(file.toPath(), line, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public List<StockOrder> readStockOrders() {
        List<StockOrder> stockOrders = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            if (lines.isEmpty()) {
                System.out.println("the file is empty");
                return stockOrders;
            }
            lines.remove(0);

            for (String line : lines) {
                String[] parts = line.split(",");
                String refStockName = parts[0];
                String accountId = parts[1];
                String stockOrderDate = parts[2];
                String stockOrderUnitPrice = parts[3];
                String stockOrderQuantity = parts[4];
                String stockOrderCommission = parts[5];

                Account account = new Account(0);
                account.setId(Integer.parseInt(accountId));
                InvestmentAccount investmentAccount = new InvestmentAccount(account);

                Stock stock = new Stock(refStockName);

                StockOrder stockOrder = new StockOrder(stock, investmentAccount,
                        stockOrderDate,
                        Double.parseDouble(stockOrderUnitPrice),
                        Integer.parseInt(stockOrderQuantity),
                        Double.parseDouble(stockOrderCommission)
                );
                stockOrders.add(stockOrder);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return stockOrders;
    }
}
