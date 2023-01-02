package fr.epita.bank.services;

import fr.epita.bank.datamodel.StockOrder;
import fr.epita.bank.exceptions.CSVServiceInitializationException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CSVService {


    private final File outputFile;

    public CSVService(File outputFile) throws CSVServiceInitializationException {
        if (!outputFile.exists()){
            try {
                Files.createFile(outputFile.toPath());
            }catch (IOException e){
                throw new CSVServiceInitializationException("unable to access persistent storage for csv service", e);
            }
        }
        this.outputFile = outputFile;
    }

    public void write(StockOrder stockOrder) {
        try {
            String content = Files.readString(outputFile.toPath());
            String newLine = System.getProperty("line.separator");
            if (content.isBlank()){

                String headers = "stockRef, accountRef, date, value, quantity, commission" + newLine;
                Files.writeString(outputFile.toPath(), headers);
            }
            String line = stockOrder.getRefStock().getName() +","
                    + stockOrder.getAccount().getCoreAccount().getId() + ","
                    + stockOrder.getDate() + ","
                    + stockOrder.getUnitPrice() + ","
                    + stockOrder.getQuantity() + ","
                    + stockOrder.getCommission() + newLine;

            Files.writeString(outputFile.toPath(), line, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public List<StockOrder> readStockOrders() {
        return null;
    }
}
