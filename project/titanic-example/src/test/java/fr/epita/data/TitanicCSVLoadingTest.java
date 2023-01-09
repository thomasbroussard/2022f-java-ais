package fr.epita.data;

import fr.epita.data.datamodel.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testGroupBy() throws IOException {
        //given
        File csvFile = new File("titanic-dataset/data.csv");// load the file
        PassengerCSVService passengerCSVService = new PassengerCSVService(csvFile); // create PassengerCSVService
        List<Passenger> completePassengersList = passengerCSVService.readAll(); // create Passenger datamodel + readAll() method

        Map<Integer, Integer> groupByPclassCount = new LinkedHashMap<>();
        for (Passenger passenger : completePassengersList){
            Integer count = groupByPclassCount.get(passenger.getpClass());
            if (count == null){
                count = 1;
            }else{
                count ++;
            }
            groupByPclassCount.put(passenger.getpClass(), count);
        }

        System.out.println(groupByPclassCount);

    }
}
