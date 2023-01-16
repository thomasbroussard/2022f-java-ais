package fr.epita.data;

import org.junit.jupiter.api.Test;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestXChart {


    public static void main(String[] args) {
        CategoryChart chart = TestXChart.getChart();
        new SwingWrapper<>(chart).displayChart();
    }


    public static CategoryChart getChart() {
        // Create Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);

        // Series
        chart.addSeries("test 1", Arrays.asList("1st Class","2nd Class", "3rd Class", "Other"), Arrays.asList(new Integer[] { 4, 5, 9, 6 }));

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
