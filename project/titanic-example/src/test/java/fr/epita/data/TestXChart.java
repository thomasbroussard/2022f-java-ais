package fr.epita.data;

import fr.epita.data.datamodel.Passenger;
import org.junit.jupiter.api.Test;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TestXChart {


    public static void main(String[] args) throws IOException {
        CategoryChart chart = TestXChart.getSurvivedDistributionPerClass();
        new SwingWrapper<>(chart).displayChart();
    }


    public static CategoryChart getChart() throws IOException {


        //given
        File csvFile = new File("titanic-example/titanic-dataset/data.csv");// load the file
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
        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);

        // Series
//        chart.addSeries("test 1", Arrays.asList("1st Class","2nd Class", "3rd Class", "Other"), Arrays.asList(new Integer[] { 4, 5, 9, 6 }));
        chart.addSeries("total number of passengers per passenger class", new ArrayList<>(groupByPclassCount.keySet()), new ArrayList<>(groupByPclassCount.values()));

        return chart;



    }

    public static CategoryChart getSurvivedDistributionPerClass() throws IOException {


        //given
        File csvFile = new File("titanic-example/titanic-dataset/data.csv");// load the file
        PassengerCSVService passengerCSVService = new PassengerCSVService(csvFile); // create PassengerCSVService
        List<Passenger> completePassengersList = passengerCSVService.readAll(); // create Passenger datamodel + readAll() method

        Map<Integer, Integer> survivedCount = new LinkedHashMap<>();
        Map<Integer, Integer> notSurvivedCount = new LinkedHashMap<>();
        for (Passenger passenger : completePassengersList) {
            Integer pclass = passenger.getpClass();
            if (passenger.getSurvived() == 0) {
                notSurvivedCount.put(pclass,notSurvivedCount.getOrDefault(pclass, 0) + 1);
            } else {
                survivedCount.put(pclass,survivedCount.getOrDefault(pclass, 0) + 1);
            }
        }

        System.out.println(notSurvivedCount);
        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);

        // Series
//        chart.addSeries("test 1", Arrays.asList("1st Class","2nd Class", "3rd Class", "Other"), Arrays.asList(new Integer[] { 4, 5, 9, 6 }));
        chart.addSeries("not survived passenger", new ArrayList<>(notSurvivedCount.keySet()), new ArrayList<>(notSurvivedCount.values()));
        chart.addSeries("survived passenger", new ArrayList<>(survivedCount.keySet()), new ArrayList<>(survivedCount.values()));

        return chart;



    }

    private static List<Double> getGaussianData(int count) {

        List<Double> data = new ArrayList<Double>(count);
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            data.add(r.nextGaussian() * 10);
        }
        return data;
    }

    private static void displayXYChart() {
        double[] xData = new double[] { 0.0, 1.0, 2.0 };
        double[] yData = new double[] { 2.0, 1.0, 0.0 };

        // Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

        // Show it
        new SwingWrapper(chart).displayChart();
    }


    @Test
    public void testDemo(){

    }
}
