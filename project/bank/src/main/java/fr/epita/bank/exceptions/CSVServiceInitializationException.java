package fr.epita.bank.exceptions;

import java.io.IOException;

public class CSVServiceInitializationException extends Throwable {
    public CSVServiceInitializationException(String s, IOException e) {
        super(s, e);
    }
}
