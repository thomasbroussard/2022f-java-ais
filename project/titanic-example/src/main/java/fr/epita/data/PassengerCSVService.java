package fr.epita.data;

import fr.epita.data.datamodel.Passenger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PassengerCSVService {
    private final File csvFile;

    private static final Map<String, Integer> pclassEncoding = new LinkedHashMap<>();

    static {
        pclassEncoding.put("1st", 1);
        pclassEncoding.put("2nd", 2);
        pclassEncoding.put("3rd", 3);
        pclassEncoding.put("default", 4);
    }

    public PassengerCSVService(File csvFile) {
        this.csvFile = csvFile;
    }

    public List<Passenger> readAll() throws IOException {
        List<String> lines = Files.readAllLines(csvFile.toPath());
        lines.remove(0);
        List<Passenger> passengers = new ArrayList<>();
        for (String line : lines){
            try {
                String[] passengerParts = line.split(";");
                Passenger passenger = new Passenger();
                passenger.setName(passengerParts[0]);
                Integer pclass = encodePclass(passengerParts[1].trim());
                passenger.setpClass(pclass);

                passenger.setAge(Double.parseDouble(passengerParts[2].trim()));
                Integer passengerSex = encodePassengerSex(passengerParts[3].trim());
                passenger.setSex(passengerSex);
                passenger.setSurvived(Integer.parseInt(passengerParts[4].trim()));
                passengers.add(passenger);
            }catch (Exception e){
                ;
                System.out.println(e.getMessage() + " in line " + line);
            }
        }
        return passengers;
    }

    private static Integer encodePassengerSex(String passengerSexAsString) {
        Integer passengerSex =  null;
        if ("female".equals(passengerSexAsString)){
            passengerSex = 1;
        } else if ("male".equals(passengerSexAsString)){
            passengerSex = 0;
        }
        return passengerSex;
    }

    private static Integer encodePclass(String passengerClass) {
        Integer pclass = pclassEncoding.get(passengerClass);
        if (pclass == null){
            pclass = pclassEncoding.get("default");
        }
        return pclass;
    }

    private static Integer encodePclassWithIfElse(String passengerClass) {
        Integer pclass = null;
        if ("1st".equals(passengerClass)){
            pclass = 1;
        } else if ("2nd".equals(passengerClass)){
            pclass = 2;
        } else if ("3rd".equals(passengerClass)){
            pclass = 3;
        } else {
            pclass = 4;
        }
        return pclass;
    }


}
