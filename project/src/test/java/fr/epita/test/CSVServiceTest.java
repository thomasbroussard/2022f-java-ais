package fr.epita.test;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.Stock;
import fr.epita.bank.datamodel.StockOrder;
import fr.epita.bank.exceptions.CSVServiceInitializationException;
import fr.epita.bank.services.CSVService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVServiceTest {

    @Test
    void write() throws CSVServiceInitializationException, IOException {
        //given
        File outputFile = new File("unit-test-write-CSVServiceTest.csv");
        CSVService service  = new CSVService(outputFile);
        Stock stock = new Stock("silver");
        Account coreAccount = new Account(0);
        InvestmentAccount account = new InvestmentAccount(coreAccount);
        coreAccount.setId(0);

        StockOrder stockOrder = new StockOrder(stock,
                account,
                "2023-01-02",
                20.0,
                2,
                2.0);

        //when
        service.write(stockOrder);

        //then
        List<String> lines = Files.readAllLines(outputFile.toPath());
        String s = lines.get(1);
        Assertions.assertTrue(s.startsWith("silver"));

    }

    @Test
    void readStockOrders() throws CSVServiceInitializationException {
        //given - hypothesis
        CSVService service  = new CSVService(new File("unit-test-CSVServiceTest.csv"));

        //when - action
        List<StockOrder> stockOrders = service.readStockOrders();

        //then - verification
        StockOrder stockOrder = stockOrders.get(0);
        Assertions.assertEquals("gold", stockOrder.getRefStock().getName());

    }
}