package fr.epita.data;

import fr.epita.data.datamodel.Passenger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class PassengerCSVService {
    private final File csvFile;

    public PassengerCSVService(File csvFile) {
        this.csvFile = csvFile;
    }

    public List<Passenger> readAll() throws IOException {
        List<String> lines = Files.readAllLines(csvFile.toPath());
        lines.remove(0);
        for (String line : lines){
            String[] passengerParts = line.split(";");
            Passenger passenger = new Passenger();
            passenger.setName(passengerParts[0]);
            passenger.setpClass(passengerParts[1]);
            passenger.setAge(Double.parseDouble(passengerParts[2]));
            passenger.setSex(passengerParts[3]);
            passenger.setSurvived(Integer.parseInt(passengerParts[4]));

        }
    }
}
