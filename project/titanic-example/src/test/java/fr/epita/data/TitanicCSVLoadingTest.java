package fr.epita.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TitanicCSVLoadingTest {


    @Test
    public void testLoadCsv(){
        //given
        File csvFile = ...;// load the file


        //when
        PassengerCSVService passengerCSVService = new PassengerCSVService(csvFile); // create PassengerCSVService
        List<Passenger> passengerList = passengerCSVService.readAll(); // create Passenger datamodel + readAll() method


        //then
        Assertions.assertTrue(passengerList.size() == 1313);

    }
}
