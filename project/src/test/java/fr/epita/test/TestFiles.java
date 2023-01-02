package fr.epita.test;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class TestFiles {

    //sandbox test
    @Test
    public void testTemplate(){
        // 0. technical setup

        // 1. hypothesis - given

        // 2. action - when

        // 3. verification - then

        // 4. clean
    }


    @Test
    public void testOpenReadSplit() throws IOException {
        File file = new File("test.csv");
        List<String> lines = Files.readAllLines(file.toPath());
        List<StockOrder> stockOrders = new ArrayList<>();
        if (lines.isEmpty()){
            System.out.println("the file is empty");
            return;
        }
        lines.remove(0);

        for (String line : lines){
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

            StockOrder stockOrder = new StockOrder(stock,investmentAccount,
                    stockOrderDate,
                    Double.parseDouble(stockOrderUnitPrice),
                    Integer.parseInt(stockOrderQuantity),
                    Double.parseDouble(stockOrderCommission)
            );
            stockOrders.add(stockOrder);
        }
        System.out.println(stockOrders);

    }

    @Test
    public void testFile() throws IOException {

        //given
        File file = new File("test.save");
        System.out.println(file.getAbsolutePath());
        try {
            if (!Files.exists(file.toPath())) {
                Files.createFile(file.toPath());
            }
            String property = System.getProperty("line.separator");
            String testString = "Test here" + property;
            Files.writeString(file.toPath(), testString);

            FileOutputStream outputStream = new FileOutputStream(file, true);
            String testString2 = "Test here 2" + property;
            outputStream.write(testString2.getBytes());
            outputStream.write(testString2.getBytes());
            outputStream.flush();
            outputStream.close();


        } catch (Exception e){
            e.printStackTrace();
        }


        Assertions.assertTrue(file.exists());

        //clean
      //  Files.delete(file.toPath());
    }

    @Test
    public void testWriteBusinessData() throws IOException {
        Stock stock = new Stock("gold");
        stock.setCurrentValue(1000.0);
        InvestmentAccount account = new InvestmentAccount(new Account(300.0));
        StockOrder stockOrder = new StockOrder(stock, account, "2022-12-01", stock.getCurrentValue(), 1, 1.0);

        //stockRef, accountRef, date, value, quantity, commission
        File outputFile = new File("test.csv");
        String headers = "stockRef, accountRef, date, value, quantity, commission" + System.getProperty("line.separator");
        Files.writeString(outputFile.toPath(), headers);

        String line = stockOrder.getRefStock().getName() +","
                + stockOrder.getAccount().getCoreAccount().getId() + ","
                + stockOrder.getDate() + ","
                + stockOrder.getUnitPrice() + ","
                + stockOrder.getQuantity() + ","
                + stockOrder.getCommission();

        //other approach:
//        String.join(",", stockOrder.getRefStock().getName(),
//                stockOrder.getAccount(),
//                stockOrder.getDate(),
//                stockOrder.getUnitPrice(),
//                stockOrder.getQuantity(),
//                stockOrder.getCommission());

        Files.writeString(outputFile.toPath(), line,StandardOpenOption.APPEND);

    }

    private static void threadDelegation(String testString, FileOutputStream outputStream) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<?> task = executor.submit(() -> {
            try {
                outputStream.write(testString.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        task.get();
    }


}
