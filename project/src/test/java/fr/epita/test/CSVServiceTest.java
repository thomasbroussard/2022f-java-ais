package fr.epita.test;

import fr.epita.bank.datamodel.StockOrder;
import fr.epita.bank.exceptions.CSVServiceInitializationException;
import fr.epita.bank.services.CSVService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVServiceTest {

    @Test
    void write() {
        //TODO write a test to validate write function works correctly
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