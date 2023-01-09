package fr.epita.data;

import fr.epita.data.datamodel.Passenger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        for (Passenger passenger : completePassengersList) {
            Integer count = groupByPclassCount.get(passenger.getpClass());
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            groupByPclassCount.put(passenger.getpClass(), count);
        }

        System.out.println(groupByPclassCount);

    }

    @Test
    public void testGroupByAge() throws IOException {
        //given
        File csvFile = new File("titanic-dataset/data.csv");// load the file
        PassengerCSVService passengerCSVService = new PassengerCSVService(csvFile); // create PassengerCSVService
        List<Passenger> completePassengersList = passengerCSVService.readAll(); // create Passenger datamodel + readAll() method

        Map<Double, Integer> groupByAgeCount = new LinkedHashMap<>();
        for (Passenger passenger : completePassengersList) {
            Integer count = groupByAgeCount.getOrDefault(passenger.getAge(), 0) + 1;
            groupByAgeCount.put(passenger.getAge(), count);
        }

        System.out.println(groupByAgeCount);
    }

    @Test
    public void testGroupUsingStream() throws IOException {
        //given
        File csvFile = new File("titanic-dataset/data.csv");// load the file
        PassengerCSVService passengerCSVService = new PassengerCSVService(csvFile); // create PassengerCSVService
        List<Passenger> completePassengersList = passengerCSVService.readAll(); // create Passenger datamodel + readAll() method

        Double averageAge = completePassengersList
                .stream()
                .mapToDouble(passenger -> passenger.getAge())
                .average()
                .getAsDouble();

        Map<Double, List<Passenger>> collect = completePassengersList
                .stream()
                .collect(Collectors.groupingBy(passenger -> passenger.getAge()));

        System.out.println(collect);
    }

    @Test
    public void testGroupingBySex() throws IOException {
        //given
        File csvFile = new File("titanic-dataset/data.csv");// load the file
        PassengerCSVService passengerCSVService = new PassengerCSVService(csvFile); // create PassengerCSVService
        List<Passenger> completePassengersList = passengerCSVService.readAll(); // create Passenger datamodel + readAll() method

        Double averageAge = completePassengersList
                .stream()
                .mapToDouble(Passenger::getAge)
                .average()
                .getAsDouble();

        Map<Integer, Integer> groupBySexCount = new LinkedHashMap<>();
        for (Passenger passenger : completePassengersList) {
            Integer count = groupBySexCount.getOrDefault(passenger.getSex(), 0) + 1;
            groupBySexCount.put(passenger.getSex(), count);
        }
        System.out.println(groupBySexCount);
    }
}
