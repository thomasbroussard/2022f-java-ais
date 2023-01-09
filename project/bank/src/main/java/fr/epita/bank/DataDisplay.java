package fr.epita.bank;

import fr.epita.bank.services.CSVService;
import fr.epita.bank.datamodel.StockOrder;
import fr.epita.bank.exceptions.CSVServiceInitializationException;

import java.io.File;
import java.util.List;

public class DataDisplay {


    public static void main(String[] args) throws CSVServiceInitializationException {
        CSVService service = new CSVService(new File("test.csv"));

        List<StockOrder> orders = service.readStockOrders();
    }

}
