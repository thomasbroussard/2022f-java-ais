package fr.epita.data;

import fr.epita.data.datamodel.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TitanicCSVLoadingTest {


    @Test
    public void testLoadCsv() throws IOException {
        //given
        File csvFile = new File("titanic-dataset/data.csv");// load the file


        //when
        PassengerCSVService passengerCSVService = new PassengerCSVService(csvFile); // create PassengerCSVService
        List<Passenger> completePassengersList = passengerCSVService.readAll(); // create Passenger datamodel + readAll() method


        //then
        System.out.println(completePassengersList.size());
        Assertions.assertTrue(completePassengersList.size() == 756);

    }
}
